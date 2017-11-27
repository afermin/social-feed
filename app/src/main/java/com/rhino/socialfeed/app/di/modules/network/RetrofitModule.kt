package com.rhino.socialfeed.app.di.modules.network

import android.content.res.Resources
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.R
import com.rhino.socialfeed.app.di.modules.FlatObjectsQualifier
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(includes = arrayOf(NetworkModule::class))
class RetrofitModule {

    @Provides
    @AppScope
    @BaseInstagramUrlQualifier
    fun provideBaseInstagramUrl(resources: Resources): String = resources.getString(R.string.base_twitter_url)

    @Provides
    @AppScope
    @BaseTwitterUrlQualifier
    fun provideBaseTwitterUrl(resources: Resources): String = resources.getString(R.string.base_instagram_url)

    @Provides
    @AppScope
    fun provideConverterFactory(@FlatObjectsQualifier moshi: Moshi): Converter.Factory =
            MoshiConverterFactory.create(moshi)

    @Provides
    @AppScope
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Provides
    @AppScope
    @TwitterAuthenticationQualifier
    fun provideTwitterRetrofit(
            @BaseTwitterUrlQualifier baseUrl: String,
            @TwitterAuthenticationQualifier client: OkHttpClient,
            converter: Converter.Factory,
            callAdapter: CallAdapter.Factory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(converter)
                    .addCallAdapterFactory(callAdapter)
                    .build()

    @Provides
    @AppScope
    @InstagramAuthenticationQualifier
    fun provideInstagramRetrofit(
            @BaseTwitterUrlQualifier baseUrl: String,
            @TwitterAuthenticationQualifier client: OkHttpClient,
            converter: Converter.Factory,
            callAdapter: CallAdapter.Factory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(converter)
                    .addCallAdapterFactory(callAdapter)
                    .build()
}
