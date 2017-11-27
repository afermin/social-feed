package com.rhino.socialfeed.app.di.modules

import com.rhino.chronometer.app.di.AppScope
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class MoshiModule {

    @Provides
    @AppScope
    fun provideMoshi(): Moshi = Moshi.Builder().build()

}

@Qualifier
annotation class FlatObjectsQualifier