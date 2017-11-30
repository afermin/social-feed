package com.rhino.socialfeed.ui.main.di

import com.rhino.socialfeed.ui.main.MainActivity
import com.rhino.socialfeed.app.di.AppComponent
import dagger.Component

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
@MainScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}