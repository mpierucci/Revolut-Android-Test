package com.mpierucci.android.revolut.rates.presentation

import com.mpierucci.android.revolut.R
import com.mpierucci.android.revolut.rates.domain.Rate
import com.mpierucci.android.revolut.rates.domain.Result
import java.text.DecimalFormat


internal fun Rate.toViewModel(isFirstResponder: Boolean, responderQuantity: Float): RateViewModel {
    val convertedValue = rateValue.times(responderQuantity).formatUpTwoDecimals()
    return when (this) {
        is Rate.Europe -> RateViewModel(
            R.drawable.ic_europe,
            R.string.eu_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Australia -> RateViewModel(
            R.drawable.ic_australia,
            R.string.australia_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Brazil -> RateViewModel(
            R.drawable.ic_brazil,
            R.string.brazil_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Bulgaria -> RateViewModel(
            R.drawable.ic_bulgaria,
            R.string.bulgaria_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.UK -> RateViewModel(
            R.drawable.ic_uk,
            R.string.uk_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.SouthAfrica -> RateViewModel(
            R.drawable.ic_south_africa,
            R.string.south_africa_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.SouthKorea -> RateViewModel(
            R.drawable.ic_south_korea,
            R.string.south_korea_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Singapore -> RateViewModel(
            R.drawable.ic_singapore,
            R.string.singapore_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Sweden -> RateViewModel(
            R.drawable.ic_sweden,
            R.string.sweden_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Switzerland -> RateViewModel(
            R.drawable.ic_switzerland,
            R.string.switzerland_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Denmark -> RateViewModel(
            R.drawable.ic_denmark,
            R.string.denmark_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.NorthAmerica -> RateViewModel(
            R.drawable.ic_usa,
            R.string.usa_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Thailand -> RateViewModel(
            R.drawable.ic_thailand,
            R.string.thailand_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Mexico -> RateViewModel(
            R.drawable.ic_mexico,
            R.string.mexico_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Russia -> RateViewModel(
            R.drawable.ic_russia,
            R.string.russia_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.India -> RateViewModel(
            R.drawable.ic_india,
            R.string.india_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Indonesia -> RateViewModel(
            R.drawable.ic_indonesia,
            R.string.indonesia_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.Philippine -> RateViewModel(
            R.drawable.ic_philippines,
            R.string.philippine_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.Iceland -> RateViewModel(
            R.drawable.ic_iceland,
            R.string.iceland_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.Canada -> RateViewModel(
            R.drawable.ic_canada,
            R.string.canada_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Croatia -> RateViewModel(
            R.drawable.ic_croatia,
            R.string.croatia_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.China -> RateViewModel(
            R.drawable.ic_china,
            R.string.china_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Czech -> RateViewModel(
            R.drawable.ic_czech,
            R.string.czech_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Malaysia -> RateViewModel(
            R.drawable.ic_malaysia,
            R.string.malaysian_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.Japan -> RateViewModel(
            R.drawable.ic_japan,
            R.string.japan_currency,
            id,
            isFirstResponder,
            convertedValue
        )
        is Rate.Norway -> RateViewModel(
            R.drawable.ic_norway,
            R.string.norway_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.Israel -> RateViewModel(
            R.drawable.ic_israel,
            R.string.israel_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.NewZealand -> RateViewModel(
            R.drawable.ic_new_zealand,
            R.string.new_zealand_currency,
            id, isFirstResponder, convertedValue
        )
        is Rate.Poland -> RateViewModel(
            R.drawable.ic_poland,
            R.string.poland_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.Hungary -> RateViewModel(
            R.drawable.ic_hungary,
            R.string.hungary_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.HongKong -> RateViewModel(
            R.drawable.ic_hong_kong,
            R.string.hong_kong_currency,
            id,
            isFirstResponder, convertedValue
        )
        is Rate.Romania -> RateViewModel(
            R.drawable.ic_romania,
            R.string.romania_currency,
            id,
            isFirstResponder, convertedValue
        )
    }
}


private val twoDecimalFormats = DecimalFormat("#.##")
internal fun Float.formatUpTwoDecimals(): String {
    return twoDecimalFormats.format(this)
}



//Convenience extension method to clear code in the view model and tests
fun Result<List<Rate>>.toRateViewModelResult(responderQuantity: Float): Result<List<RateViewModel>> {
    return when (this) {
        is Result.Success -> {
            Result.Success(
                data.mapIndexed { index, rate ->
                    rate.toViewModel(index == 0, responderQuantity)
                }
            )
        }
        is Result.Error -> Result.Error(this.exception)
    }
}