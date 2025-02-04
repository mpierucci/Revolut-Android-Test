package com.mpierucci.android.revolut.rates.presentation

import com.mpierucci.android.revolut.R
import com.mpierucci.android.revolut.rates.domain.Defaults.DEFAULT_CURRENCY_ID
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
            firstResponder = true,
            flagRes = R.drawable.ic_hong_kong,
            nameRes = R.string.app_name,
            currencyId = "EUR"
        )
        val observer = subject.test()

        userInputDelegate.handleRateClicked(rate)

        observer.assertValueCount(1)
        observer.assertValues(UserInput("EUR", "12"))

        observer.dispose()
    }


    @Test
    fun `handle quantity emits user input`() {
        val subject = PublishSubject.create<UserInput>()
        val userInputDelegate = UserInputDelegate(subject)


        val observer = subject.test()

        userInputDelegate.handleResponderQuantityChanged("12")

        observer.assertValueCount(1)
        observer.assertValues(UserInput(DEFAULT_CURRENCY_ID, "12"))

        observer.dispose()
    }
}