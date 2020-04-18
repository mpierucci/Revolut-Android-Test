package com.mpierucci.android.revolut.rates.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpierucci.android.revolut.rates.domain.RatesRepository
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RatesViewModel @Inject constructor(
    ratesRepository: RatesRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _rates = MutableLiveData<List<RateViewModel>>()
    val rates: LiveData<List<RateViewModel>> = _rates

    init {
        compositeDisposable.add(
            ratesRepository.getRates("EUR")
                .repeatWhen { it.delay(1, TimeUnit.SECONDS) }
                .map { rates ->
                    rates.map { it.toViewModel(false, 1f) }
                }
                .subscribe {
                    _rates.postValue(it)
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}