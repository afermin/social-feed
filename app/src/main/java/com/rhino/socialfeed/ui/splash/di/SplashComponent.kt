package com.rhino.socialfeed.ui.splash.di

import com.rhino.socialfeed.app.di.AppComponent
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.settings.SettingsFragment
import com.rhino.socialfeed.ui.splash.SplashActivity
import dagger.Component

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@SplashScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(SplashModule::class))
interface SplashComponent {
    fun inject(activity: SplashActivity)
}