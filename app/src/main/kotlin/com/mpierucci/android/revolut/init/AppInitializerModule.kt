package com.mpierucci.android.revolut.init

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
abstract class AppInitializerModule {

    @Binds
    @IntoSet
    abstract fun bindTimberInitializer(initializer: TimberInitializer): AppInitializer
}