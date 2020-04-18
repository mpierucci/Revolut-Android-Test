package com.mpierucci.android.revolut.rates.data

import com.mpierucci.android.revolut.rates.domain.Rate
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RateResponseMappingTest {

    @Test
    fun `maps all rates`() {
        val response = RatesResponse(
            "EUR",
            mapOf(
                "USD" to 5f,
                "AUD" to 10f
            )
        )

        val model = response.toRateList()

        assertThat(model).hasSize(3)
    }

    @Test
    fun `base currency is mapped to responder rate`() {
        val response = RatesResponse(
            "EUR",
            mapOf(
                "USD" to 5f,
                "AUD" to 10f
            )
        )

        val model = response.toRateList()
        val responder = model.first()

        assertThat(responder).isInstanceOf(Rate.Europe::class.java)
    }

    @Test
    fun `invalid rates are removed from the list`() {
        val response = RatesResponse(
            "EUR",
            mapOf(
                "Arg" to 5f,
                "AUD" to 10f
            )
        )

        val model = response.toRateList()

        assertThat(model).hasSize(2)
    }

    @Test
    fun `maps broken response gracefully`() {
        val response = RatesResponse(
            baseCurrency = null,
            rates = emptyMap()
        )

        val model = response.toRateList()

        assertThat(model).isEmpty()
    }
}