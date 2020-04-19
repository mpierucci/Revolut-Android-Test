package com.mpierucci.android.revolut.rates.ui

import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.RecyclerView
import com.mpierucci.android.revolut.databinding.RateItemListBinding
import com.mpierucci.android.revolut.rates.presentation.RateViewModel
import io.reactivex.subjects.PublishSubject

class RatesViewHolder(
    private val binding: RateItemListBinding,
    private val positionClickPublisher: PublishSubject<Int>,
    private val textChangePublisher: PublishSubject<CharSequence>
) : RecyclerView.ViewHolder(binding.root) {


    private var ignoreTextChange = false

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) {}

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (!ignoreTextChange) textChangePublisher.onNext(s)
        }
    }

    init {
        itemView.setOnClickListener {
            positionClickPublisher.onNext(adapterPosition)
        }
    }


    fun bindRate(rate: RateViewModel) {
        ignoreTextChange = true
        binding.currencyName.text = itemView.context.getString(rate.nameRes)
        binding.currencyCode.text = rate.currencyId
        binding.currencyFlag.setImageResource(rate.flagRes)
        binding.currencyConvertedValue.setText(rate.convertedValue)
        binding.currencyConvertedValue.isEnabled = rate.editable
        ignoreTextChange = false

        if (adapterPosition == 0) {
            binding.currencyConvertedValue.addTextChangedListener(textWatcher)
        } else {
            binding.currencyConvertedValue.removeTextChangedListener(textWatcher)
        }
    }

    fun updateConversion(convertedValue: String, editable: Boolean) {
        ignoreTextChange = true
        binding.currencyConvertedValue.setText(convertedValue)
        binding.currencyConvertedValue.isEnabled = editable
        ignoreTextChange = false
    }
}