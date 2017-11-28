package com.rhino.socialfeed.ui.settings.di

import android.content.Context
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.app.di.modules.api.InstagramApi
import com.rhino.socialfeed.ui.instagram.di.InstagramFragmentScope
import com.rhino.socialfeed.ui.instagram.mvp.InstagramContract
import com.rhino.socialfeed.ui.instagram.mvp.InstagramModel
import com.rhino.socialfeed.ui.main.MainActivity
import com.rhino.socialfeed.ui.settings.SettingsFragment
import com.rhino.socialfeed.ui.settings.mvp.SettingsContract
import com.rhino.socialfeed.ui.settings.mvp.SettingsModel
import com.rhino.socialfeed.ui.settings.mvp.SettingsPresenter
import com.rhino.socialfeed.ui.settings.mvp.SettingsView
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@Module
class SettingsModule(private val fragment: SettingsFragment) {

    @Provides
    @SettingsScope
    fun provideActivity(): MainActivity = fragment.activity as MainActivity

    @Provides
    @SettingsScope
    fun provideView(activity: MainActivity
    ): SettingsContract.View =
            SettingsView(activity = activity)

    @Provides
    @SettingsScope
    fun provideModel(sessionManager: SessionManager):
            SettingsContract.Model = SettingsModel(sessionManager = sessionManager)

    @Provides
    @SettingsScope
    fun providePresenter(
            view: SettingsContract.View,
            model: SettingsContract.Model,
            sessionManager: SessionManager
    ): SettingsContract.Presenter =
            SettingsPresenter(view = view, model = model, sessionManager = sessionManager)

    @Provides
    @SettingsScope
    fun provideContext(activity: MainActivity): Context = activity

}