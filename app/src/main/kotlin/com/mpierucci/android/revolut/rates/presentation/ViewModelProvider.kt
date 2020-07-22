package com.mpierucci.android.revolut.rates.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mpierucci.android.revolut.rates.domain.RatesInteractor
import javax.inject.Inject

interface AssistedViewModelProvider<out T : ViewModel> {
    fun create(savedStateHandle: SavedStateHandle): T
}


internal class AssistedRatesViewModelProvider @Inject constructor(
    private val ratesInteractor: RatesInteractor,
    private val userInputDelegate: UserInputHandler
) : AssistedViewModelProvider<RatesViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): RatesViewModel {
        return RatesViewModel(ratesInteractor, userInputDelegate, savedStateHandle)
    }
}
