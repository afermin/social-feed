package com.rhino.socialfeed.app.di.modules

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.rhino.socialfeed.app.di.modules.network.NetworkModule
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.AppModule
import com.rhino.socialfeed.app.di.AppQualifier
import com.squareup.picasso.Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = arrayOf(NetworkModule::class, AppModule::class))
class PicassoModule {

    @Provides
    @AppScope
    fun provideDownloader(okHttpClient: OkHttpClient): Downloader = OkHttp3Downloader(okHttpClient)

    @Provides
    @AppScope
    fun providePicasso(@AppQualifier context: Context, downloader: Downloader): Picasso =
            Picasso.Builder(context)
                    .downloader(downloader)
                    .build()

}