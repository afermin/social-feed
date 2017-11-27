package com.rhino.socialfeed.app.di


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

@Module
class AppModule(private val app: SocialFeedApplication) {

    @Provides
    @AppScope
    fun provideApp(): SocialFeedApplication = app

    @Provides
    @AppScope
    @AppQualifier
    fun provideApplicationContext(): Context = app

    @Provides
    @AppScope
    fun provideResources(): Resources = app.resources

}
