package com.mpierucci.android.revolut.init

import android.app.Application
import com.mpierucci.android.revolut.di.DaggerAppComponent
import javax.inject.Inject

class RevolutApp : Application() {

    val appComponent by lazy { DaggerAppComponent.factory().create() }

    @Inject
    lateinit var initializer: AppInitializers

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        initializer.init(this)
    }
}