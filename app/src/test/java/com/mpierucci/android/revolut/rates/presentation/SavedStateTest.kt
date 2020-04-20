package com.mpierucci.android.revolut.rates.presentation

import androidx.lifecycle.SavedStateHandle
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class SavedStateTest {

    @Test
    fun `stores user input`() {
        val userInput = UserInputHandler.UserInput("EUR", 4f)
        val savedState = mock<SavedStateHandle>()

        savedState.saveUserInput(userInput)

        verify(savedState).set(CURRENCY_KEY, "EUR")
        verify(savedState).set(QUANTITY_KEY, 4f)
    }

    @Test
    fun `retrieves user input`() {
        val savedState = mock<SavedStateHandle>()

        savedState.retrieveUserInput()

        verify(savedState).get<String>(CURRENCY_KEY)
        verify(savedState).get<Float>(QUANTITY_KEY)
    }
}