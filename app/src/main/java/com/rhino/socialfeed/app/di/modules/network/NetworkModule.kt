package com.rhino.socialfeed.app.di.modules.network

import android.content.Context
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.BuildConfig
import com.rhino.socialfeed.app.di.AppModule
import com.rhino.socialfeed.app.di.AppQualifier
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import java.io.File

@Module(includes = arrayOf(AppModule::class))
class NetworkModule {

    @Provides
    @AppScope
    @CacheQualifier
    fun provideCacheFile(@AppQualifier context: Context): File =
            File(context.cacheDir, "okhttp-cache")

    @Provides
    @AppScope
    @CacheQualifier
    fun provideCacheMaxSize(): Long = 10 * 1024 * 1024

    @Provides
    @AppScope
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
    }

    @Provides
    @AppScope
    fun provideCache(@CacheQualifier file: File, @CacheQualifier maxSize: Long): Cache =
            Cache(file, maxSize)

    @Provides
    @AppScope
    fun provideOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient =
            OkHttpClient.Builder()
                    .cache(cache)
                    .addInterceptor(httpLoggingInterceptor)
                    .build()

    @Provides
    @AppScope
    @TwitterAuthenticationQualifier
    fun provideAuthenticatedOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor,
            authenticationInterceptor: TwitterAuthenticationInterceptor,
            cache: Cache): OkHttpClient =
            OkHttpClient.Builder()
                    .cache(cache)
                    .addInterceptor(authenticationInterceptor)
                    .addInterceptor(httpLoggingInterceptor)
                    .build()
    @Provides
    @AppScope
    @InstagramAuthenticationQualifier
    fun provideInstagramAuthenticatedOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor,
            authenticationInterceptor: InstagramAuthenticationInterceptor,
            cache: Cache): OkHttpClient =
            OkHttpClient.Builder()
                    .cache(cache)
                    .addInterceptor(authenticationInterceptor)
                    .addInterceptor(httpLoggingInterceptor)
                    .build()
}