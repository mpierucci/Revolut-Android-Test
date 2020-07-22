package com.mpierucci.android.revolut.rates.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.mpierucci.android.revolut.rates.domain.Defaults
import com.mpierucci.android.revolut.rates.domain.RatesInteractor
import com.mpierucci.android.revolut.rates.domain.Result
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class RatesViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val interactor = mock<RatesInteractor>()
    private val inputDelegate = mock<UserInputHandler>()
    private val savedStateHandle = mock<SavedStateHandle>()
    private val defaultUserInput = UserInputHandler.UserInput(
        Defaults.DEFAULT_CURRENCY_ID, Defaults.DEFAULT_RESPONDER_QUANTITY
    )

    private lateinit var viewModel: RatesViewModel

    @Before
    fun setUp() {
        whenever(interactor.execute(any())).thenReturn(
            Flowable.just(
                Result.Success(
                    emptyList()
                )
            )
        )
        whenever(inputDelegate.userInput).thenReturn(Flowable.empty())
        whenever(savedStateHandle.get<String>(CURRENCY_KEY)).thenReturn(Defaults.DEFAULT_CURRENCY_ID)
        whenever(savedStateHandle.get<String>(QUANTITY_KEY)).thenReturn(Defaults.DEFAULT_RESPONDER_QUANTITY)
        viewModel =
            RatesViewModel(interactor, inputDelegate, savedStateHandle)
    }


    @Test
    fun `starts with user input from saved state when polling`() {
        viewModel.startPollingRates()

        verify(savedStateHandle).retrieveUserInput()
    }

    @Test
    fun `saves user input into saved state when polling`() {
        viewModel.startPollingRates()

        verify(savedStateHandle).retrieveUserInput()
    }

    @Test
    fun `rates repository executes upon poling`() {
        viewModel.startPollingRates()

        verify(interactor).execute(any())
    }

}