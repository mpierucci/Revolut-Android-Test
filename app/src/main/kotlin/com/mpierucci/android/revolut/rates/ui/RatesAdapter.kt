package com.mpierucci.android.revolut.rates.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mpierucci.android.revolut.databinding.RateItemListBinding
import com.mpierucci.android.revolut.rates.presentation.RateViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RatesAdapter : ListAdapter<RateViewModel, RatesViewHolder>(RatesUtilCallback()) {

    private val positionClickPublisher = PublishSubject.create<Int>()
    val responderQuantityChanged = PublishSubject.create<CharSequence>()

    val rateClicked: Observable<RateViewModel>
        get() = positionClickPublisher.map {
            getItem(it)
        }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        holder.bindRate(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        val bindings = RateItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RatesViewHolder(bindings, positionClickPublisher, responderQuantityChanged)
    }

    override fun onBindViewHolder(
        holder: RatesViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val payload = payloads.firstOrNull()
        (payload as? String)?.let { convertedValue ->
            holder.updateConversion(convertedValue, getItem(position).editable)
        } ?: kotlin.run {
            onBindViewHolder(holder, position)
        }
    }
}