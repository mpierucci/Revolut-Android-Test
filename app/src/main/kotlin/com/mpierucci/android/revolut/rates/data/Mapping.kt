package com.mpierucci.android.revolut.rates.data

import com.mpierucci.android.revolut.rates.domain.Rate
import timber.log.Timber


internal fun RatesResponse.toRateList(): List<Rate> {
    val domainRates = mutableListOf<Rate>()

    baseCurrency?.toRate(1f)?.let { responderRate ->
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
internal fun String.toRate(rateValue: Float): Rate? {
    return when (this) {
        "EUR" -> Rate.Europe(rateValue, this)
        "AUD" -> Rate.Australia(rateValue, this)
        "BGN" -> Rate.Bulgaria(rateValue, this)
        "BRL" -> Rate.Brazil(rateValue, this)
        "CAD" -> Rate.Canada(rateValue, this)
        "CHF" -> Rate.Switzerland(rateValue, this)
        "CNY" -> Rate.China(rateValue, this)
        "CZK" -> Rate.Czech(rateValue, this)
        "DKK" -> Rate.Denmark(rateValue, this)
        "GBP" -> Rate.UK(rateValue, this)
        "HKD" -> Rate.HongKong(rateValue, this)
        "HRK" -> Rate.Croatia(rateValue, this)
        "HUF" -> Rate.Hungary(rateValue, this)
        "IDR" -> Rate.Indonesia(rateValue, this)
        "ILS" -> Rate.Israel(rateValue, this)
        "INR" -> Rate.India(rateValue, this)
        "ISK" -> Rate.Iceland(rateValue, this)
        "JPY" -> Rate.Japan(rateValue, this)
        "KRW" -> Rate.SouthKorea(rateValue, this)
        "MXN" -> Rate.Mexico(rateValue, this)
        "MYR" -> Rate.Malaysia(rateValue, this)
        "NOK" -> Rate.Norway(rateValue, this)
        "NZD" -> Rate.NewZealand(rateValue, this)
        "PHP" -> Rate.Philippine(rateValue, this)
        "PLN" -> Rate.Poland(rateValue, this)
        "RON" -> Rate.Romania(rateValue, this)
        "RUB" -> Rate.Russia(rateValue, this)
        "SEK" -> Rate.Sweden(rateValue, this)
        "SGD" -> Rate.Singapore(rateValue, this)
        "THB" -> Rate.Thailand(rateValue, this)
        "USD" -> Rate.NorthAmerica(rateValue, this)
        "ZAR" -> Rate.SouthAfrica(rateValue, this)
        else -> {
            Timber.e("Unhandled rate currency: $this")
            null
        }
    }
}