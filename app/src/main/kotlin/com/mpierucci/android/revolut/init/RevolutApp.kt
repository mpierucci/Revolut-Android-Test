package com.mpierucci.android.revolut.init

import android.app.Application
import com.mpierucci.android.revolut.di.DaggerAppComponent

class RevolutApp : Application() {

    val appComponent by lazy { DaggerAppComponent.factory().create() }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}