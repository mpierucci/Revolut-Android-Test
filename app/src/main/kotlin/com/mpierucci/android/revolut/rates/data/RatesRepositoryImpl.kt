package com.mpierucci.android.revolut.rates.data

import com.mpierucci.android.revolut.rates.domain.Rate
import com.mpierucci.android.revolut.rates.domain.RatesRepository
import io.reactivex.Flowable
import javax.inject.Inject

internal class RatesRepositoryImpl @Inject constructor(
    private val ratesApi: RatesApi
) : RatesRepository {

    override fun getRates(baseCurrency: String): Flowable<List<Rate>> {
        return ratesApi.getRates(baseCurrency)
            .map { it.toRateList() }
    }
}