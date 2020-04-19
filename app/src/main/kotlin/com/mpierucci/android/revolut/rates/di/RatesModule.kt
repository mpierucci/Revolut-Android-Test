package com.mpierucci.android.revolut.rates.di

import com.mpierucci.android.revolut.rates.data.RatesApi
import com.mpierucci.android.revolut.rates.data.RatesRepositoryImpl
import com.mpierucci.android.revolut.rates.domain.RatesRepository
import com.mpierucci.android.revolut.rates.presentation.UserInputDelegate
import com.mpierucci.android.revolut.rates.presentation.UserInputHandler
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject
import retrofit2.Retrofit

@Module
internal object RatesModule {

    @Provides
    fun provideRatesRepository(repositoryImpl: RatesRepositoryImpl): RatesRepository =
        repositoryImpl

    @Provides
    fun provideRateApi(retrofit: Retrofit): RatesApi = retrofit.create(RatesApi::class.java)

    @Provides
    fun provideUserInputDelegate() : UserInputHandler=
        UserInputDelegate(PublishSubject.create())
}