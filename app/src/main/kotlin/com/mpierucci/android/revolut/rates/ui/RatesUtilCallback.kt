package com.mpierucci.android.revolut.rates.ui

import androidx.recyclerview.widget.DiffUtil
import com.mpierucci.android.revolut.rates.presentation.RateViewModel

class RatesUtilCallback : DiffUtil.ItemCallback<RateViewModel>() {

    override fun areItemsTheSame(oldItem: RateViewModel, newItem: RateViewModel) =
        oldItem.currencyId == newItem.currencyId

    override fun areContentsTheSame(oldItem: RateViewModel, newItem: RateViewModel) =
        oldItem == newItem

    override fun getChangePayload(oldItem: RateViewModel, newItem: RateViewModel): Any? {
        return if (oldItem.convertedValue != newItem.convertedValue)
            newItem.convertedValue
        else null
    }

}