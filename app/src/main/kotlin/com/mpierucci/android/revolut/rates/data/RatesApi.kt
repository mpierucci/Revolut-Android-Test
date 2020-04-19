package com.mpierucci.android.revolut.rates.data

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesApi {
    @GET("latest")
    fun getRates(@Query(value = "base") base: String): Flowable<RatesResponse>
}