package com.mpierucci.android.revolut.init

import android.app.Application
import javax.inject.Inject

class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {

    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}