package com.mpierucci.android.revolut.rates.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpierucci.android.revolut.rates.domain.RatesInteractor
import com.mpierucci.android.revolut.rates.domain.Result
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class RatesViewModel @Inject constructor(
    private val ratesInteractor: RatesInteractor,
    private val userInputDelegate: UserInputDelegate
) : ViewModel(), UserInputHandler by userInputDelegate {

    private val compositeDisposable = CompositeDisposable()
    private val _rates = MutableLiveData<List<RateViewModel>>()


    val rates: LiveData<List<RateViewModel>> = _rates

    init {
        compositeDisposable.add(
            userInputDelegate.userInput
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
                Timber.e("Mappeando")
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

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}