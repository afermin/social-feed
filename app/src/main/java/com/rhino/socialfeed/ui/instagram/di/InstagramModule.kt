package com.rhino.socialfeed.ui.instagram.di

import android.content.Context
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.app.di.modules.api.InstagramApi
import com.rhino.socialfeed.ui.instagram.InstagramAdapter
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.instagram.mvp.InstagramContract
import com.rhino.socialfeed.ui.instagram.mvp.InstagramModel
import com.rhino.socialfeed.ui.instagram.mvp.InstagramPresenter
import com.rhino.socialfeed.ui.instagram.mvp.InstagramView
import com.rhino.socialfeed.ui.main.MainActivity
import com.rhino.socialfeed.ui.main.di.MainScope
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
@Module
class InstagramModule(private val fragment: InstagramFragment) {

    @Provides
    @InstagramFragmentScope
    fun provideActivity(): MainActivity = fragment.activity as MainActivity

    @Provides
    @InstagramFragmentScope
    fun provideModel(sessionManager: SessionManager, instagramApi: InstagramApi):
            InstagramContract.Model = InstagramModel(
            fragment = fragment,
            sessionManager = sessionManager,
            instagramApi = instagramApi
    )

    @Provides
    @InstagramFragmentScope
    fun provideView(activity: MainActivity, adapter: InstagramAdapter, picasso: Picasso
    ): InstagramContract.View =
            InstagramView(activity = activity, adapter = adapter, picasso = picasso)

    @Provides
    @InstagramFragmentScope
    fun providePresenter(
            view: InstagramContract.View,
            model: InstagramContract.Model,
            sessionManager: SessionManager
    ): InstagramContract.Presenter =
            InstagramPresenter(view = view, model = model, sessionManager = sessionManager)

    @Provides
    @InstagramFragmentScope
    fun provideContext(activity: MainActivity): Context = activity

}