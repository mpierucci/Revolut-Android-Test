package com.mpierucci.android.revolut.rates.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpierucci.android.revolut.rates.domain.RatesInteractor
import com.mpierucci.android.revolut.rates.domain.Result
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class RatesViewModel @Inject constructor(
    private val ratesInteractor: RatesInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _rates = MutableLiveData<List<RateViewModel>>()
    private val rateClickedItPublisher = PublishSubject.create<String>()
    private val responderQuantityPublisher = PublishSubject.create<Float>()

    val rates: LiveData<List<RateViewModel>> = _rates

    init {
        compositeDisposable.add(
                 userInputFlowable()
                .switchMap { params -> flowable(params.currencyId, params.responderQuantity) }
                .subscribe { result ->
                    when (result) {
                        is Result.Success -> _rates.postValue(result.data)
                        is Result.Error -> {
                        } //Todo handle error after release 1.0
                    }
                }
        )
    }

    private fun flowable(
        id: String,
        quantity: Float
    ): Flowable<Result<List<RateViewModel>>> {
        return ratesInteractor.execute(id)
            .map {
                when (it) {
                    is Result.Success -> Result.Success(it.data.mapIndexed { index, rate ->
                        rate.toViewModel(
                            index == 0,
                            quantity
                        )
                    })
                    is Result.Error -> Result.Error(it.exception)
                }
            }
    }

    private fun userInputFlowable(): Flowable<RateParams> {
        return Flowable.combineLatest(
            rateClickedItPublisher.toFlowable(BackpressureStrategy.LATEST).startWith("EUR"),
            responderQuantityPublisher.toFlowable(BackpressureStrategy.LATEST).startWith(1f),
            BiFunction<String, Float, RateParams> { currencyId, responderQuantity ->
                RateParams(
                    currencyId,
                    responderQuantity
                )
            }
        )
    }

    fun onRateClicked(rate: RateViewModel) {
        rateClickedItPublisher.onNext(rate.currencyId)
    }

    fun onResponderQuantityChanged(quantity: String) {
        quantity.toFloatOrNull()?.let {
            responderQuantityPublisher.onNext(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    data class RateParams(val currencyId: String, val responderQuantity: Float)
}