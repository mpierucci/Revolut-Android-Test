package com.mpierucci.android.revolut.rates.presentation

import com.mpierucci.android.revolut.rates.domain.Rate
import com.mpierucci.android.revolut.rates.domain.Result
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.math.BigDecimal

class ViewModelResultTest {

    @Test
    fun `maps success result`() {
        val domainResult = Result.Success(listOf<Rate>())

        val model = domainResult.toRateViewModelResult(BigDecimal("12"))

        assertThat(model).isInstanceOf(Result.Success::class.java)

    }

    @Test
    fun `maps error result`() {

        val domainResult = Result.Error(IllegalArgumentException())

        val model = domainResult.toRateViewModelResult(BigDecimal("12"))

        assertThat(model).isInstanceOf(Result.Error::class.java)
    }
}