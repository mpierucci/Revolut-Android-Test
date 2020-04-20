package com.mpierucci.android.revolut.init

import android.app.Application
import com.mpierucci.android.revolut.di.DaggerAppComponent
import com.mpierucci.android.revolut.network.ReleaseSchedulersProvider
import javax.inject.Inject

class RevolutApp : Application() {

    val appComponent by lazy { DaggerAppComponent.factory().create(ReleaseSchedulersProvider()) }

    @Inject
    lateinit var initializer: AppInitializers

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        initializer.init(this)
    }
}