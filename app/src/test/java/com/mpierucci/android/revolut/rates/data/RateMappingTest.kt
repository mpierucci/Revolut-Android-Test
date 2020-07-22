package com.mpierucci.android.revolut.rates.data

import com.mpierucci.android.revolut.rates.domain.Rate
import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import java.math.BigDecimal

class RateMappingTest {

    @Test
    fun `maps into europe rate`() {
        val model = "EUR".toRate("4")

        assertThat(model).isInstanceOf(Rate.Europe::class.java)
    }

    @Test
    fun `maps into astralia rate`() {
        val model = "AUD".toRate("4")

        assertThat(model).isInstanceOf(Rate.Australia::class.java)
    }

    @Test
    fun `maps into bulgaria rate`() {
        val model = "BGN".toRate("4")

        assertThat(model).isInstanceOf(Rate.Bulgaria::class.java)
    }

    @Test
    fun `maps into brazil rate`() {
        val model = "BRL".toRate("4")

        assertThat(model).isInstanceOf(Rate.Brazil::class.java)
    }

    @Test
    fun `maps into canada rate`() {
        val model = "CAD".toRate("4")

        assertThat(model).isInstanceOf(Rate.Canada::class.java)
    }


    @Test
    fun `maps into switzerland rate`() {
        val model = "CHF".toRate("4")

        assertThat(model).isInstanceOf(Rate.Switzerland::class.java)
    }

    @Test
    fun `maps into china  rate`() {
        val model = "CNY".toRate("4")

        assertThat(model).isInstanceOf(Rate.China::class.java)
    }

    @Test
    fun `maps into Czech  rate`() {
        val model = "CZK".toRate("4")

        assertThat(model).isInstanceOf(Rate.Czech::class.java)
    }

    @Test
    fun `maps into denmark  rate`() {
        val model = "DKK".toRate("4")

        assertThat(model).isInstanceOf(Rate.Denmark::class.java)
    }

    @Test
    fun `maps into hong kong  rate`() {
        val model = "HKD".toRate("4")

        assertThat(model).isInstanceOf(Rate.HongKong::class.java)
    }

    @Test
    fun `maps into uk  rate`() {
        val model = "GBP".toRate("4")

        assertThat(model).isInstanceOf(Rate.UK::class.java)
    }

    @Test
    fun `maps into croatia  rate`() {
        val model = "HRK".toRate("4")

        assertThat(model).isInstanceOf(Rate.Croatia::class.java)
    }

    @Test
    fun `maps into hungary  rate`() {
        val model = "HUF".toRate("4")

        assertThat(model).isInstanceOf(Rate.Hungary::class.java)
    }

    @Test
    fun `maps into indonesia  rate`() {
        val model = "IDR".toRate("4")

        assertThat(model).isInstanceOf(Rate.Indonesia::class.java)
    }

    @Test
    fun `maps into isreal  rate`() {
        val model = "ILS".toRate("4")

        assertThat(model).isInstanceOf(Rate.Israel::class.java)
    }

    @Test
    fun `maps into india  rate`() {
        val model = "INR".toRate("4")

        assertThat(model).isInstanceOf(Rate.India::class.java)
    }

    @Test
    fun `maps into iceland  rate`() {
        val model = "ISK".toRate("4")

        assertThat(model).isInstanceOf(Rate.Iceland::class.java)
    }

    @Test
    fun `maps into japan  rate`() {
        val model = "JPY".toRate("4")

        assertThat(model).isInstanceOf(Rate.Japan::class.java)
    }

    @Test
    fun `maps into south korea  rate`() {
        val model = "KRW".toRate("4")

        assertThat(model).isInstanceOf(Rate.SouthKorea::class.java)
    }

    @Test
    fun `maps into mexico  rate`() {
        val model = "MXN".toRate("4")

        assertThat(model).isInstanceOf(Rate.Mexico::class.java)
    }

    @Test
    fun `maps into norway  rate`() {
        val model = "NOK".toRate("4")

        assertThat(model).isInstanceOf(Rate.Norway::class.java)
    }

    @Test
    fun `maps into new zealand  rate`() {
        val model = "NZD".toRate("4")

        assertThat(model).isInstanceOf(Rate.NewZealand::class.java)
    }

    @Test
    fun `maps into philippine  rate`() {
        val model = "PHP".toRate("4")

        assertThat(model).isInstanceOf(Rate.Philippine::class.java)
    }

    @Test
    fun `maps into poland  rate`() {
        val model = "PLN".toRate("4")

        assertThat(model).isInstanceOf(Rate.Poland::class.java)
    }

    @Test
    fun `maps into romania  rate`() {
        val model = "RON".toRate("4")

        assertThat(model).isInstanceOf(Rate.Romania::class.java)
    }

    @Test
    fun `maps into russia  rate`() {
        val model = "RUB".toRate("4")

        assertThat(model).isInstanceOf(Rate.Russia::class.java)
    }

    @Test
    fun `maps into sweden  rate`() {
        val model = "SEK".toRate("4")

        assertThat(model).isInstanceOf(Rate.Sweden::class.java)
    }

    @Test
    fun `maps into singapore  rate`() {
        val model = "SGD".toRate("4")

        assertThat(model).isInstanceOf(Rate.Singapore::class.java)
    }

    @Test
    fun `maps into thai baht  rate`() {
        val model = "THB".toRate("4")

        assertThat(model).isInstanceOf(Rate.Thailand::class.java)
    }

    @Test
    fun `maps into north america  rate`() {
        val model = "USD".toRate("4")

        assertThat(model).isInstanceOf(Rate.NorthAmerica::class.java)
    }

    @Test
    fun `maps into south africa  rate`() {
        val model = "ZAR".toRate("4")

        assertThat(model).isInstanceOf(Rate.SouthAfrica::class.java)
    }

    @Test
    fun `maps into malaysia  rate`() {
        val model = "MYR".toRate("4")

        assertThat(model).isInstanceOf(Rate.Malaysia::class.java)
    }


    @Test
    fun `maps rate value`() {
        val model = "EUR".toRate("4")

        assertThat(model?.rateValue).isEqualTo(BigDecimal("4"))
    }

    @Test
    fun `maps id value`() {
        val model = "EUR".toRate("4")

        assertThat(model?.id).isEqualTo("EUR")
    }

    @Test
    fun `maps unhandled currency to null`() {
        val model = "ARG".toRate("4")

        assertThat(model).isNull()
    }
}