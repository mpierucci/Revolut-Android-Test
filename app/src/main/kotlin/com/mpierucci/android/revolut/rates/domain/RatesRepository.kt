package com.mpierucci.android.revolut.rates.domain

import io.reactivex.Flowable

internal interface RatesRepository {
    fun getRates(baseCurrency: String): Flowable<List<Rate>>
}