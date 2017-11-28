package com.rhino.socialfeed.app.di

import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.modules.MoshiModule
import com.rhino.socialfeed.app.di.modules.network.NetworkModule
import com.rhino.socialfeed.app.di.modules.PicassoModule
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.app.di.modules.TwitterAppModule
import com.rhino.socialfeed.app.di.modules.api.ApiModule
import com.rhino.socialfeed.app.di.modules.api.InstagramApi
import com.squareup.picasso.Picasso
import dagger.Component

@AppScope
@Component(modules = arrayOf(
        AppModule::class,
        TwitterAppModule::class,
        NetworkModule::class,
        PicassoModule::class,
        MoshiModule::class,
        ApiModule::class)
)
interface AppComponent {
    fun inject(app: SocialFeedApplication)
    fun sessionManager(): SessionManager
    fun instagramApi(): InstagramApi
    fun picasso(): Picasso
}
