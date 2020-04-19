package com.mpierucci.android.revolut.rates.domain

import io.reactivex.Flowable

interface FlowableInteractor<PARAM, RESULT> {
    fun execute(params: PARAM): Flowable<RESULT>
}