package com.rhino.socialfeed.app

import android.app.Application
import android.app.Service
import android.support.v4.app.FragmentActivity
import com.rhino.socialfeed.R
import com.rhino.socialfeed.app.di.AppComponent
import com.rhino.socialfeed.app.di.AppModule
import com.rhino.socialfeed.app.di.DaggerAppComponent
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterConfig
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class SocialFeedApplication : Application() {

    private lateinit var appComponent: AppComponent
    @Inject lateinit var twitterConfig: TwitterConfig

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this)).build()

        appComponent.inject(this)

        Twitter.initialize(twitterConfig)


        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build())
    }

    fun component(): AppComponent? = appComponent

    companion object {

        operator fun get(activity: FragmentActivity): SocialFeedApplication =
                activity.application as SocialFeedApplication

        operator fun get(service: Service): SocialFeedApplication =
                service.application as SocialFeedApplication
    }

}
