package com.mpierucci.android.revolut.di

import com.mpierucci.android.revolut.init.AppInitializerModule
import com.mpierucci.android.revolut.init.RevolutApp
import com.mpierucci.android.revolut.network.NetworkModule
import com.mpierucci.android.revolut.network.SchedulersProvider
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, AppInitializerModule::class])
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance schedulersProvider: SchedulersProvider): AppComponent
    }

    val retrofit: Retrofit

    val schedulersProvider: SchedulersProvider

    fun inject(application: RevolutApp)
}