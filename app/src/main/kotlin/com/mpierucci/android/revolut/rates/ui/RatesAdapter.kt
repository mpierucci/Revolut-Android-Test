package com.mpierucci.android.revolut.rates.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mpierucci.android.revolut.databinding.RateItemListBinding
import com.mpierucci.android.revolut.rates.presentation.RateViewModel

class RatesAdapter : ListAdapter<RateViewModel, RatesViewHolder>(RatesUtilCallback()) {

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        holder.bindRate(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        val bindings = RateItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RatesViewHolder(bindings)
    }

    override fun onBindViewHolder(
        holder: RatesViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val payload = payloads.firstOrNull()
        (payload as? String)?.let { convertedValue ->
            holder.updateConversion(convertedValue)
        } ?: kotlin.run {
            onBindViewHolder(holder, position)
        }
    }
}