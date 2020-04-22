package com.mpierucci.android.revolut.rates.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RatesResponse(
    val baseCurrency: String?,
    val rates: Map<String, String> = emptyMap()
)

