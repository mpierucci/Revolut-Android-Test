package com.mpierucci.android.revolut.rates.presentation

import com.mpierucci.android.revolut.rates.presentation.UserInputHandler.UserInput
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

import io.reactivex.subjects.PublishSubject

class UserInputDelegate(
    private val userInputSubject: PublishSubject<UserInput>
) : UserInputHandler {

    private var _userInput = UserInput("EUR", 1f)

    override val userInput: Flowable<UserInput> =
        userInputSubject.toFlowable(BackpressureStrategy.LATEST).startWith(_userInput)


    override fun handleRateClicked(rate: RateViewModel) {
        _userInput = UserInput(rate.currencyId, rate.convertedValue.toFloatOrZero()).also {
            userInputSubject.onNext(it)
        }
    }

    override fun handleResponderQuantityChanged(quantity: String) {
        _userInput = _userInput.copy(responderQuantity = quantity.toFloatOrZero()).also {
            userInputSubject.onNext(it)
        }
    }

    private fun String.toFloatOrZero() = toFloatOrNull() ?: 0f
}