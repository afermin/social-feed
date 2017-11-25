package com.rhino.socialfeed.activities.main.di

import com.rhino.socialfeed.activities.main.MainActivity
import com.rhino.socialfeed.app.di.AppComponent
import dagger.Component

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@MainScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}