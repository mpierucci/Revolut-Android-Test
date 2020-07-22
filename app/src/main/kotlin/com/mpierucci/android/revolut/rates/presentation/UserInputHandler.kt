package com.mpierucci.android.revolut.rates.presentation

import io.reactivex.Flowable

interface UserInputHandler {

    val userInput: Flowable<UserInput>

    fun handleRateClicked(rate: RateViewModel)

    fun handleResponderQuantityChanged(quantity: String)

    data class UserInput(val currencyId: String, val responderQuantity: String)
}