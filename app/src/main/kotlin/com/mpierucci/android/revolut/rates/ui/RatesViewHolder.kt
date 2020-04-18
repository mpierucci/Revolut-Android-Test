package com.mpierucci.android.revolut.rates.ui

import androidx.recyclerview.widget.RecyclerView
import com.mpierucci.android.revolut.databinding.RateItemListBinding
import com.mpierucci.android.revolut.rates.presentation.RateViewModel

class RatesViewHolder(private val binding: RateItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bindRate(rate: RateViewModel) {
        binding.currencyName.text = itemView.context.getString(rate.nameRes)
        binding.currencyCode.text = rate.currencyId
        binding.currencyFlag.setImageResource(rate.flagRes)
        binding.currencyConvertedValue.setText(rate.convertedValue)
        binding.currencyConvertedValue.isEnabled = rate.editable
    }

    fun updateConversion(convertedValue: String) {
        binding.currencyConvertedValue.setText(convertedValue)
    }
}