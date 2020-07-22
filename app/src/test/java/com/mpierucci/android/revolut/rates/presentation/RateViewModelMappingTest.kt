package com.mpierucci.android.revolut.rates.presentation

import com.mpierucci.android.revolut.R
import com.mpierucci.android.revolut.rates.domain.Rate
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.math.BigDecimal

class RateViewModelMappingTest {

    @Test
    fun `maps romania rate`() {
        val rate = Rate.Romania(BigDecimal("3"), "RON")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            "RON",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps australia rate`() {
        val rate = Rate.Australia(BigDecimal("3"), "AUD")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_australia,
            R.string.australia_currency,
            "AUD",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps bulgaria rate`() {
        val rate = Rate.Bulgaria(BigDecimal("3"), "BGN")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_bulgaria,
            R.string.bulgaria_currency,
            "BGN",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps brazil rate`() {
        val rate = Rate.Brazil(BigDecimal("3"), "BRL")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_brazil,
            R.string.brazil_currency,
            "BRL",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps canada rate`() {
        val rate = Rate.Canada(BigDecimal("3"), "CAD")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_canada,
            R.string.canada_currency,
            "CAD",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps switzerland rate`() {
        val rate = Rate.Switzerland(BigDecimal("3"), "CHF")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_switzerland,
            R.string.switzerland_currency,
            "CHF",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps china rate`() {
        val rate = Rate.China(BigDecimal("3"), "CNY")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_china,
            R.string.china_currency,
            "CNY",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps czech rate`() {
        val rate = Rate.Czech(BigDecimal("3"), "CZK")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_czech,
            R.string.czech_currency,
            "CZK",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps denmark rate`() {
        val rate = Rate.Denmark(BigDecimal("3"), "DKK")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_denmark,
            R.string.denmark_currency,
            "DKK",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps uk rate`() {
        val rate = Rate.UK(BigDecimal("3"), "GBP")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_uk,
            R.string.uk_currency,
            "GBP",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps hong kong rate`() {
        val rate = Rate.HongKong(BigDecimal("3"), "HKD")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_hong_kong,
            R.string.hong_kong_currency,
            "HKD",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps croatia rate`() {
        val rate = Rate.Croatia(BigDecimal("3"), "HRK")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_croatia,
            R.string.croatia_currency,
            "HRK",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps hungary rate`() {
        val rate = Rate.Hungary(BigDecimal("3"), "HUF")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_hungary,
            R.string.hungary_currency,
            "HUF",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps indonesia rate`() {
        val rate = Rate.Indonesia(BigDecimal("3"), "IDR")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_indonesia,
            R.string.indonesia_currency,
            "IDR",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps israel rate`() {
        val rate = Rate.Israel(BigDecimal("3"), "ILS")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_israel,
            R.string.israel_currency,
            "ILS",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps india rate`() {
        val rate = Rate.India(BigDecimal("3"), "INR")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_india,
            R.string.india_currency,
            "INR",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps iceland rate`() {
        val rate = Rate.Iceland(BigDecimal("3"), "ISK")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_iceland,
            R.string.iceland_currency,
            "ISK",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps japan rate`() {
        val rate = Rate.Japan(BigDecimal("3"), "JPY")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_japan,
            R.string.japan_currency,
            "JPY",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps south korea rate`() {
        val rate = Rate.SouthKorea(BigDecimal("3"), "KRW")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_south_korea,
            R.string.south_korea_currency,
            "KRW",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps mexico rate`() {
        val rate = Rate.Mexico(BigDecimal("3"), "MXN")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_mexico,
            R.string.mexico_currency,
            "MXN",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps malaysia rate`() {
        val rate = Rate.Malaysia(BigDecimal("3"), "MYR")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_malaysia,
            R.string.malaysian_currency,
            "MYR",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps norway rate`() {
        val rate = Rate.Norway(BigDecimal("3"), "NOK")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_norway,
            R.string.norway_currency,
            "NOK",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps mew zealand rate`() {
        val rate = Rate.NewZealand(BigDecimal("3"), "NZD")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_new_zealand,
            R.string.new_zealand_currency,
            "NZD",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps philippine rate`() {
        val rate = Rate.Philippine(BigDecimal("3"), "PHP")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_philippines,
            R.string.philippine_currency,
            "PHP",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps poland rate`() {
        val rate = Rate.Poland(BigDecimal("3"), "PLN")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_poland,
            R.string.poland_currency,
            "PLN",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps eu rate`() {
        val rate = Rate.Europe(BigDecimal("3"), "EUR")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_europe,
            R.string.eu_currency,
            "EUR",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps russia rate`() {
        val rate = Rate.Russia(BigDecimal("3"), "RUB")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_russia,
            R.string.russia_currency,
            "RUB",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps sweden rate`() {
        val rate = Rate.Sweden(BigDecimal("3"), "SEK")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_sweden,
            R.string.sweden_currency,
            "SEK",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps singapore rate`() {
        val rate = Rate.Singapore(BigDecimal("3"), "SGD")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_singapore,
            R.string.singapore_currency,
            "SGD",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps thailand rate`() {
        val rate = Rate.Thailand(BigDecimal("3"), "THB")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_thailand,
            R.string.thailand_currency,
            "THB",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps usa rate`() {
        val rate = Rate.NorthAmerica(BigDecimal("3"), "USD")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_usa,
            R.string.usa_currency,
            "USD",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }

    @Test
    fun `maps south africa rate`() {
        val rate = Rate.SouthAfrica(BigDecimal("3"), "ZAR")
        val model = rate.toViewModel(false, BigDecimal("4"))

        val expected = RateViewModel(
            R.drawable.ic_south_africa,
            R.string.south_africa_currency,
            "ZAR",
            false,
            "12"
        )

        assertThat(model).isEqualTo(expected)
    }
}