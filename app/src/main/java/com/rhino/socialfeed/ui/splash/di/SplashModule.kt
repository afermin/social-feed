package com.rhino.socialfeed.ui.splash.di

import android.content.Context
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.app.di.modules.api.InstagramApi
import com.rhino.socialfeed.ui.splash.SplashActivity
import com.rhino.socialfeed.ui.splash.mvp.SplashContract
import com.rhino.socialfeed.ui.splash.mvp.SplashModel
import com.rhino.socialfeed.ui.splash.mvp.SplashPresenter
import com.rhino.socialfeed.ui.splash.mvp.SplashView
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@Module
class SplashModule(private val activity: SplashActivity) {

    @Provides
    @SplashScope
    fun provideView(): SplashContract.View =
            SplashView(activity = activity)

    @Provides
    @SplashScope
    fun provideModel(sessionManager: SessionManager, instagramApi: InstagramApi
    ): SplashContract.Model =
            SplashModel(activity = activity,
                    sessionManager = sessionManager,
                    instagramApi = instagramApi)

    @Provides
    @SplashScope
    fun providePresenter(
            view: SplashContract.View,
            model: SplashContract.Model,
            sessionManager: SessionManager
    ): SplashContract.Presenter =
            SplashPresenter(view = view, model = model, sessionManager = sessionManager)

    @Provides
    @SplashScope
    fun provideContext(activity: SplashActivity): Context = activity

}