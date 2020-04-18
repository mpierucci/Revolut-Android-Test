package com.mpierucci.android.revolut.rates.ui

import com.mpierucci.android.revolut.R
import com.mpierucci.android.revolut.rates.presentation.RateViewModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RatesUtilCallbackTest {

    @Test
    fun `are items the same on same items`() {
        val callback = RatesUtilCallback()

        val model = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )

        val areItemsTheSame = callback.areItemsTheSame(model, model)

        assertThat(areItemsTheSame).isTrue()
    }

    @Test
    fun `are items the same on different items`() {
        val callback = RatesUtilCallback()

        val model = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )


        val newModel = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "GBP",
            false,
            "12"
        )

        val areItemsTheSame = callback.areItemsTheSame(model, newModel)

        assertThat(areItemsTheSame).isFalse()
    }

    @Test
    fun `are content the same on same items`() {
        val callback = RatesUtilCallback()

        val model = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )

        val areItemsTheSame = callback.areItemsTheSame(model, model)
        val areContentTheSame = callback.areContentsTheSame(model, model)

        assertThat(areItemsTheSame).isTrue()
        assertThat(areContentTheSame).isTrue()
    }

    @Test
    fun `are content the same on different items`() {
        val callback = RatesUtilCallback()

        val model = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )


        val newModel = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "123"
        )

        val areItemsTheSame = callback.areItemsTheSame(model, newModel)
        val areContentTheSame = callback.areContentsTheSame(model, newModel)

        assertThat(areItemsTheSame).isTrue()
        assertThat(areContentTheSame).isFalse()
    }


    @Test
    fun `provides difference payload if converted value differs`() {
        val callback = RatesUtilCallback()

        val model = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )


        val newModel = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "123"
        )

        val areItemsTheSame = callback.areItemsTheSame(model, newModel)
        val areContentTheSame = callback.areContentsTheSame(model, newModel)
        val payload = callback.getChangePayload(model, newModel)

        assertThat(areItemsTheSame).isTrue()
        assertThat(areContentTheSame).isFalse()
        assertThat(payload).isEqualTo("123")
    }

    @Test
    fun `no difference payload if change isn't on converted value`() {
        val callback = RatesUtilCallback()

        val model = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )


        val newModel = RateViewModel(
            R.drawable.ic_usa,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )

        val areItemsTheSame = callback.areItemsTheSame(model, newModel)
        val areContentTheSame = callback.areContentsTheSame(model, newModel)
        val payload = callback.getChangePayload(model, newModel)

        assertThat(areItemsTheSame).isTrue()
        assertThat(areContentTheSame).isFalse()
        assertThat(payload).isNull()
    }
}