package com.mpierucci.android.revolut.rates.domain

import com.mpierucci.android.revolut.rates.TestSchedulersProvider
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import io.reactivex.schedulers.TestScheduler
import org.junit.Test
import java.util.concurrent.TimeUnit


class RatesInteractorTest {

    private val schedulersProvider = TestSchedulersProvider()

    @Test
    fun `tests success result`() {
        val repository = mock<RatesRepository>()
        val interactor = RatesInteractor(repository, schedulersProvider)

        whenever(repository.getRates(any())).thenReturn(Flowable.just(emptyList()))

        val subscriber = interactor.execute("EUR").test()

        subscriber.assertValues(Result.Success(emptyList()))

        subscriber.dispose()
    }

    @Test
    fun `tests error result`() {
        val repository = mock<RatesRepository>()
        val interactor = RatesInteractor(repository, schedulersProvider)
        val exception = IllegalStateException()

        whenever(repository.getRates(any())).thenReturn(Flowable.error(exception))

        val subscriber = interactor.execute("EUR").test()

        subscriber.assertValues(Result.Error(exception))

        subscriber.dispose()
    }


    @Test
    fun `tests repeat result`() {
        val repository = mock<RatesRepository>()
        val interactor = RatesInteractor(repository, schedulersProvider)

        val testScheduler = TestScheduler()

        whenever(repository.getRates(any())).thenReturn(Flowable.fromArray(emptyList()))

        val subscriber = interactor.execute("EUR")
            .subscribeOn(testScheduler)
            .observeOn(testScheduler)
            .test()

        subscriber.assertNotTerminated().assertValueCount(0)

        testScheduler.advanceTimeBy(1L, TimeUnit.SECONDS)

        subscriber.assertValues(Result.Success(emptyList()))

        subscriber.dispose()
    }
}