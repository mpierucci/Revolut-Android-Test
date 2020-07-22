package com.mpierucci.android.revolut.rates.presentation

import androidx.activity.ComponentActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import com.mpierucci.android.revolut.rates.domain.RatesInteractor
import javax.inject.Inject



internal inline fun <reified T : ViewModel> ComponentActivity.savedStateVM(
    crossinline provider: (handle: SavedStateHandle) -> T
) = assistedViewModels<T> {

    object : AbstractSavedStateViewModelFactory(this, intent.extras) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return provider(handle) as T
        }
    }
}

inline fun <reified VM : ViewModel> ComponentActivity.assistedViewModels(
    noinline factoryProducer: () -> AbstractSavedStateViewModelFactory
): ViewModelLazy<VM> {
    return ViewModelLazy(VM::class, { viewModelStore }, factoryProducer)
}
