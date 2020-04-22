package com.mpierucci.android.revolut.rates.data

import com.mpierucci.android.revolut.rates.domain.Rate
import timber.log.Timber


internal fun RatesResponse.toRateList(): List<Rate> {
    val domainRates = mutableListOf<Rate>()

    baseCurrency?.toRate("1")?.let { responderRate ->
        domainRates.add(responderRate)
    }

    rates.entries.forEach { rateEntry ->
        rateEntry.key.toRate(rateEntry.value)?.let {
            domainRates.add(it)
        }
    }

    return domainRates
}

//See readme disclaimers
internal fun String.toRate(rateValue: String): Rate? {
    return when (this) {
        "EUR" -> Rate.Europe(rateValue.toBigDecimal(), this)
        "AUD" -> Rate.Australia(rateValue.toBigDecimal(), this)
        "BGN" -> Rate.Bulgaria(rateValue.toBigDecimal(), this)
        "BRL" -> Rate.Brazil(rateValue.toBigDecimal(), this)
        "CAD" -> Rate.Canada(rateValue.toBigDecimal(), this)
        "CHF" -> Rate.Switzerland(rateValue.toBigDecimal(), this)
        "CNY" -> Rate.China(rateValue.toBigDecimal(), this)
        "CZK" -> Rate.Czech(rateValue.toBigDecimal(), this)
        "DKK" -> Rate.Denmark(rateValue.toBigDecimal(), this)
        "GBP" -> Rate.UK(rateValue.toBigDecimal(), this)
        "HKD" -> Rate.HongKong(rateValue.toBigDecimal(), this)
        "HRK" -> Rate.Croatia(rateValue.toBigDecimal(), this)
        "HUF" -> Rate.Hungary(rateValue.toBigDecimal(), this)
        "IDR" -> Rate.Indonesia(rateValue.toBigDecimal(), this)
        "ILS" -> Rate.Israel(rateValue.toBigDecimal(), this)
        "INR" -> Rate.India(rateValue.toBigDecimal(), this)
        "ISK" -> Rate.Iceland(rateValue.toBigDecimal(), this)
        "JPY" -> Rate.Japan(rateValue.toBigDecimal(), this)
        "KRW" -> Rate.SouthKorea(rateValue.toBigDecimal(), this)
        "MXN" -> Rate.Mexico(rateValue.toBigDecimal(), this)
        "MYR" -> Rate.Malaysia(rateValue.toBigDecimal(), this)
        "NOK" -> Rate.Norway(rateValue.toBigDecimal(), this)
        "NZD" -> Rate.NewZealand(rateValue.toBigDecimal(), this)
        "PHP" -> Rate.Philippine(rateValue.toBigDecimal(), this)
        "PLN" -> Rate.Poland(rateValue.toBigDecimal(), this)
        "RON" -> Rate.Romania(rateValue.toBigDecimal(), this)
        "RUB" -> Rate.Russia(rateValue.toBigDecimal(), this)
        "SEK" -> Rate.Sweden(rateValue.toBigDecimal(), this)
        "SGD" -> Rate.Singapore(rateValue.toBigDecimal(), this)
        "THB" -> Rate.Thailand(rateValue.toBigDecimal(), this)
        "USD" -> Rate.NorthAmerica(rateValue.toBigDecimal(), this)
        "ZAR" -> Rate.SouthAfrica(rateValue.toBigDecimal(), this)
        else -> {
            Timber.e("Unhandled rate currency: $this")
            null
        }
    }
}