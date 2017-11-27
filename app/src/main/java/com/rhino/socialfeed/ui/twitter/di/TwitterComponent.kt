package com.rhino.socialfeed.ui.twitter.di

import com.rhino.socialfeed.app.di.AppComponent
import com.rhino.socialfeed.ui.main.di.MainScope
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import dagger.Component

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@TwitterFragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(TwitterModule::class))
interface TwitterComponent {
    fun inject(fragment: TwitterFragment)
}