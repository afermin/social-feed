package com.rhino.socialfeed.app.di

import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.modules.MoshiModule
import com.rhino.socialfeed.app.di.modules.network.NetworkModule
import com.rhino.socialfeed.app.di.modules.PicassoModule
import com.rhino.socialfeed.app.di.modules.TwitterAppModule
import dagger.Component

@AppScope
@Component(modules = arrayOf(
        AppModule::class,
        TwitterAppModule::class,
        NetworkModule::class,
        PicassoModule::class,
        MoshiModule::class)
)
interface AppComponent {
    fun inject(app: SocialFeedApplication)
}
