package com.rhino.socialfeed.ui.instagram.di

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.instagram.mvp.InstagramContract
import com.rhino.socialfeed.ui.instagram.mvp.InstagramModel
import com.rhino.socialfeed.ui.instagram.mvp.InstagramPresenter
import com.rhino.socialfeed.ui.instagram.mvp.InstagramView
import com.rhino.socialfeed.ui.main.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@Module
class InstagramModule(private val fragment: InstagramFragment) {

    @Provides
    @InstagramFragmentScope
    fun provideActivity(): MainActivity = fragment.activity as MainActivity

    @Provides
    @InstagramFragmentScope
    fun provideModel(sessionManager: SessionManager): InstagramContract.Model = InstagramModel(
            fragment = fragment,
            sessionManager = sessionManager
    )

    @Provides
    @InstagramFragmentScope
    fun provideView(activity: MainActivity
    ): InstagramContract.View = InstagramView(activity = activity)

    @Provides
    @InstagramFragmentScope
    fun providePresenter(
            view: InstagramContract.View,
            model: InstagramContract.Model,
            sessionManager: SessionManager
    ): InstagramContract.Presenter =
            InstagramPresenter(view = view, model = model, sessionManager = sessionManager)


}