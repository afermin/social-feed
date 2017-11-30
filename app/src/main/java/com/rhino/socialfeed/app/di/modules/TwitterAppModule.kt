package com.rhino.socialfeed.app.di.modules

import android.content.Context
import android.util.Log
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.AppModule
import com.rhino.socialfeed.app.di.AppQualifier
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import dagger.Module
import dagger.Provides

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
@Module(includes = arrayOf(AppModule::class))
class TwitterAppModule {

    @Provides
    @AppScope
    fun provideTwitterConfig(@AppQualifier context: Context): TwitterConfig =
            TwitterConfig.Builder(context)
                    .logger(DefaultLogger(Log.DEBUG))
                    .twitterAuthConfig(TwitterAuthConfig("7EllonhI3SzQFmS5g8Lsflx8t",
                            "sfqQhUWcoiCt6El6FoAKtc7VKXWuidvuytY7m8Etcz5KN1KmLr"))
                    .debug(true)
                    .build()

}
