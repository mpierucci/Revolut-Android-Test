package com.mpierucci.android.revolut.rates.domain

import io.reactivex.Flowable

interface RatesRepository {
    fun getRates(baseCurrency: String): Flowable<List<Rate>>
}