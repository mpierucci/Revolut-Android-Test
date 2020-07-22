package com.mpierucci.android.revolut.rates.data

import com.mpierucci.android.revolut.rates.domain.Rate
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.math.BigDecimal

class RateResponseMappingTest {

    @Test
    fun `maps all rates`() {
        val response = RatesResponse(
            "EUR",
            mapOf(
                "USD" to "5",
                "AUD" to "10"
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
                "USD" to "5",
                "AUD" to "10"
            )
        )

        val model = response.toRateList()
        val responder = model.first()

        assertThat(responder).isInstanceOf(Rate.Europe::class.java)
        assertThat(responder.rateValue).isEqualTo(BigDecimal("1"))
    }

    @Test
    fun `invalid rates are removed from the list`() {
        val response = RatesResponse(
            "EUR",
            mapOf(
                "Arg" to "5",
                "AUD" to "10"
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