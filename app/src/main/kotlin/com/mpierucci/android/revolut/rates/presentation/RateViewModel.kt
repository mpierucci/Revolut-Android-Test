package com.mpierucci.android.revolut.rates.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RateViewModel(
    @DrawableRes val flagRes: Int,
    @StringRes val nameRes: Int,
    val currencyId: String,
    val firstResponder: Boolean,
    val convertedValue: String
)