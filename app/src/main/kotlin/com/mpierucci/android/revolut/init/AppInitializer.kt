package com.mpierucci.android.revolut.init

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}