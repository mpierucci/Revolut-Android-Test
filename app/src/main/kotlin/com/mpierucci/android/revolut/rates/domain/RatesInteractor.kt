package com.mpierucci.android.revolut.rates.domain

import com.mpierucci.android.revolut.network.SchedulersProvider
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RatesInteractor @Inject constructor(
    private val repository: RatesRepository,
    private val schedulersProvider: SchedulersProvider
) :
    FlowableInteractor<String, Result<List<Rate>>> {

    override fun execute(params: String): Flowable<Result<List<Rate>>> {
        return repository.getRates(params)
            .subscribeOn(schedulersProvider.io())
            .repeatWhen { it.delay(1, TimeUnit.SECONDS) }
            .map<Result<List<Rate>>> { Result.Success(it) }
            .onErrorReturn { Result.Error(it) }
    }

}