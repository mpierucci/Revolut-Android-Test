package com.mpierucci.android.revolut.rates.presentation

import com.mpierucci.android.revolut.rates.domain.Defaults.DEFAULT_CURRENCY_ID
import com.mpierucci.android.revolut.rates.domain.Defaults.DEFAULT_RESPONDER_QUANTITY
import com.mpierucci.android.revolut.rates.presentation.UserInputHandler.UserInput
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject

class UserInputDelegate(
    private val userInputSubject: PublishSubject<UserInput>
) : UserInputHandler {

    private var _userInput = UserInput(DEFAULT_CURRENCY_ID, DEFAULT_RESPONDER_QUANTITY)

    override val userInput: Flowable<UserInput> =
        userInputSubject.toFlowable(BackpressureStrategy.LATEST)


    override fun handleRateClicked(rate: RateViewModel) {
        _userInput = UserInput(rate.currencyId, rate.convertedValue).also {
            userInputSubject.onNext(it)
        }
    }

    override fun handleResponderQuantityChanged(quantity: String) {
        _userInput = _userInput.copy(responderQuantity = quantity).also {
            userInputSubject.onNext(it)
        }
    }
}