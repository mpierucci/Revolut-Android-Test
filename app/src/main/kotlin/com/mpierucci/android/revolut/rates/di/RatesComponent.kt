package com.mpierucci.android.revolut.rates.di

import com.mpierucci.android.revolut.di.AppComponent
import com.mpierucci.android.revolut.rates.ui.RatesActivity
import dagger.Component


@Component(dependencies = [AppComponent::class], modules = [RatesModule::class])
@FeatureScope
interface RatesComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): RatesComponent
    }

    fun inject(activity: RatesActivity)
}