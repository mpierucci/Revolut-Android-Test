package com.mpierucci.android.revolut.rates.domain

internal sealed class Rate() {
    abstract val rateValue: Float
    abstract val id: String

    data class Europe(override val rateValue: Float, override val id: String) : Rate()
    data class Australia(override val rateValue: Float, override val id: String) : Rate()
    data class Bulgaria(override val rateValue: Float, override val id: String) : Rate()
    data class Brazil(override val rateValue: Float, override val id: String) : Rate()
    data class Canada(override val rateValue: Float, override val id: String) : Rate()
    data class Switzerland(override val rateValue: Float, override val id: String) : Rate()
    data class China(override val rateValue: Float, override val id: String) : Rate()
    data class Czech(override val rateValue: Float, override val id: String) : Rate()
    data class Denmark(override val rateValue: Float, override val id: String) : Rate()
    data class UK(override val rateValue: Float, override val id: String) : Rate()
    data class HongKong(override val rateValue: Float, override val id: String) : Rate()
    data class Croatia(override val rateValue: Float, override val id: String) : Rate()
    data class Hungary(override val rateValue: Float, override val id: String) : Rate()
    data class Indonesia(override val rateValue: Float, override val id: String) : Rate()
    data class Israel(override val rateValue: Float, override val id: String) : Rate()
    data class India(override val rateValue: Float, override val id: String) : Rate()
    data class Iceland(override val rateValue: Float, override val id: String) : Rate()
    data class Japan(override val rateValue: Float, override val id: String) : Rate()
    data class SouthKorea(override val rateValue: Float, override val id: String) : Rate()
    data class Mexico(override val rateValue: Float, override val id: String) : Rate()
    data class Malaysia(override val rateValue: Float, override val id: String) : Rate()
    data class Norway(override val rateValue: Float, override val id: String) : Rate()
    data class NewZealand(override val rateValue: Float, override val id: String) : Rate()
    data class Philippine(override val rateValue: Float, override val id: String) : Rate()
    data class Poland(override val rateValue: Float, override val id: String) : Rate()
    data class Romania(override val rateValue: Float, override val id: String) : Rate()
    data class Russia(override val rateValue: Float, override val id: String) : Rate()
    data class Sweden(override val rateValue: Float, override val id: String) : Rate()
    data class Singapore(override val rateValue: Float, override val id: String) : Rate()
    data class ThaiBaht(override val rateValue: Float, override val id: String) : Rate()
    data class NorthAmerica(override val rateValue: Float, override val id: String) : Rate()
    data class SouthAfrica(override val rateValue: Float, override val id: String) : Rate()
}