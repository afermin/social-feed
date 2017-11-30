package com.rhino.socialfeed.ui.settings.di

import com.rhino.socialfeed.app.di.AppComponent
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.settings.SettingsFragment
import dagger.Component

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
@SettingsScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(SettingsModule::class))
interface SettingsComponent {
    fun inject(fragment: SettingsFragment)
}