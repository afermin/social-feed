package com.rhino.socialfeed.app.di.modules.api

import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.modules.network.InstagramAuthenticationQualifier
import com.rhino.socialfeed.app.di.modules.network.RetrofitModule
import com.rhino.socialfeed.app.di.modules.network.TwitterAuthenticationQualifier
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = arrayOf(RetrofitModule::class))
class ApiModule {

    @Provides
    @AppScope
    fun provideAuthApi(@TwitterAuthenticationQualifier retrofit: Retrofit):
            TwitterApi = retrofit.create(TwitterApi::class.java)

    @Provides
    @AppScope
    fun provideInstagramApi(@InstagramAuthenticationQualifier retrofit: Retrofit):
            InstagramApi = retrofit.create(InstagramApi::class.java)

}