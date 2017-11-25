package com.rhino.socialfeed.app.di

import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.modules.AppModule
import com.rhino.socialfeed.app.di.modules.TwitterModule
import dagger.Component

@AppScope
@Component(modules = arrayOf(AppModule::class, TwitterModule::class))
interface AppComponent {
    fun inject(app: SocialFeedApplication)
}
