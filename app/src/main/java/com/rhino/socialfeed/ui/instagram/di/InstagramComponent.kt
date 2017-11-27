package com.rhino.socialfeed.ui.instagram.di

import com.rhino.socialfeed.app.di.AppComponent
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import dagger.Component

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@InstagramFragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(InstagramModule::class))
interface InstagramComponent {
    fun inject(fragment: InstagramFragment)
}