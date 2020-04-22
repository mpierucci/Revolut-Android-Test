package com.mpierucci.android.revolut.rates.presentation

import androidx.lifecycle.SavedStateHandle
import com.mpierucci.android.revolut.rates.domain.Defaults
import com.mpierucci.android.revolut.rates.presentation.UserInputHandler.UserInput

internal const val CURRENCY_KEY = "currency"
internal const val QUANTITY_KEY = "quantity"

internal fun SavedStateHandle.retrieveUserInput(): UserInput {
    return UserInput(
        get<String>(CURRENCY_KEY) ?: Defaults.DEFAULT_CURRENCY_ID,
        get<String>(QUANTITY_KEY) ?: Defaults.DEFAULT_RESPONDER_QUANTITY
    )
}

internal fun SavedStateHandle.saveUserInput(userInput: UserInput) {
    set(CURRENCY_KEY, userInput.currencyId)
    set(QUANTITY_KEY, userInput.responderQuantity)
}