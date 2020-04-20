package com.mpierucci.android.revolut.rates.presentation

import androidx.core.os.bundleOf
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
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

internal class RatesViewModelFactory(
    private val assistedRatesViewModelProvider: AssistedViewModelProvider<RatesViewModel>,
    owner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(owner, bundleOf()) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return  assistedRatesViewModelProvider.create(handle) as T
    }
}