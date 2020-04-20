package com.mpierucci.android.revolut.rates.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mpierucci.android.revolut.rates.domain.RatesInteractor
import com.mpierucci.android.revolut.rates.domain.Result
import com.mpierucci.android.revolut.rates.presentation.UserInputHandler.UserInput
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class RatesViewModel(
    private val ratesInteractor: RatesInteractor,
    private val userInputDelegate: UserInputHandler,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), UserInputHandler by userInputDelegate {

    private val compositeDisposable = CompositeDisposable()
    private val _rates = MutableLiveData<Result<List<RateViewModel>>>()

    val rates: LiveData<Result<List<RateViewModel>>> = _rates

    init {
        compositeDisposable.add(
            userInputDelegate.userInput.startWith(savedStateHandle.retrieveUserInput())
                .switchMap(::fetchRates)
                .subscribe(::handleRatesResult)
        )
    }

    private fun fetchRates(userInput: UserInput):
            Flowable<Result<List<RateViewModel>>> {
        return ratesInteractor.execute(userInput.currencyId)
            .map {
                savedStateHandle.saveUserInput(userInput)
                it.toRateViewModelResult(userInput.responderQuantity)
            }
    }

    private fun handleRatesResult(result: Result<List<RateViewModel>>) {
        _rates.postValue(result)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}