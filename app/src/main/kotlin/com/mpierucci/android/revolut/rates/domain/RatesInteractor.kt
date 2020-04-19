package com.mpierucci.android.revolut.rates.domain

import io.reactivex.Flowable
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RatesInteractor @Inject constructor(private val repository: RatesRepository) :
    FlowableInteractor<String, Result<List<Rate>>> {

    override fun execute(params: String): Flowable<Result<List<Rate>>> {
        return repository.getRates(params)
            .repeatWhen { it.delay(1, TimeUnit.SECONDS) }
            .map<Result<List<Rate>>> { Result.Success(it) }
            .onErrorReturn { Result.Error(it) }
    }

}