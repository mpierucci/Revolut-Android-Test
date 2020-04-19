package com.mpierucci.android.revolut.rates.presentation

import com.mpierucci.android.revolut.R
import com.mpierucci.android.revolut.rates.presentation.UserInputHandler.UserInput
import io.reactivex.subjects.PublishSubject
import org.junit.Test

class UserInputDelegateTest {

    @Test
    fun `handle rate clicked emits user input`() {
        val subject = PublishSubject.create<UserInput>()
        val userInputDelegate = UserInputDelegate(subject)
        val rate = RateViewModel(
            convertedValue = "12",
            editable = true,
            flagRes = R.drawable.ic_hong_kong,
            nameRes = R.string.app_name,
            currencyId = "EUR"
        )
        val observer = subject.test()

        userInputDelegate.handleRateClicked(rate)

        observer.assertValueCount(1)
        observer.assertValues(UserInput("EUR", 12f))

        observer.dispose()
    }


    @Test
    fun `handle quantity emits user input`() {
        val subject = PublishSubject.create<UserInput>()
        val userInputDelegate = UserInputDelegate(subject)


        val observer = subject.test()

        userInputDelegate.handleResponderQuantityChanged("12")

        observer.assertValueCount(1)
        observer.assertValues(UserInput("EUR", 12f))

        observer.dispose()
    }

    @Test
    fun `delegate starts with initial values`() {
        val subject = PublishSubject.create<UserInput>()
        val userInputDelegate = UserInputDelegate(subject)

        val observer = userInputDelegate.userInput.test()

        observer.assertValues(UserInput("EUR", 1f))

        observer.dispose()
    }
}