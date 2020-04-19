package com.mpierucci.android.revolut.rates.data

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.junit.Test

class RatesRepositoryImplTest {

    @Test
    fun `gets rates through rates api`() {
        val mockedApi = mock<RatesApi>()
        val mockedResponse = mock<RatesResponse>()
        val repository = RatesRepositoryImpl(mockedApi)

        whenever(mockedApi.getRates(any())).thenReturn(Flowable.just(mockedResponse))

        val observer = repository.getRates("EUR").test()

        verify(mockedApi).getRates("EUR")
        verify(mockedResponse).toRateList()

        observer.dispose()
    }
}