package com.rhino.socialfeed.app.di.modules

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.SocialFeedApplication
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@Module
class TwitterModule (private val context: Context) {

    @Provides
    @AppScope
    fun provideTwitterConfit(): TwitterConfig =
            TwitterConfig.Builder(context)
                    .logger(DefaultLogger(Log.DEBUG))
                    .twitterAuthConfig(TwitterAuthConfig("CONSUMER_KEY", "CONSUMER_SECRET"))
                    .debug(true)
                    .build()

}
