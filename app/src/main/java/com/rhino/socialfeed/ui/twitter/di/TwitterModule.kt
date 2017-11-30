package com.rhino.socialfeed.ui.twitter.di

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.ui.main.MainActivity
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import com.rhino.socialfeed.ui.twitter.mvp.TwitterContract
import com.rhino.socialfeed.ui.twitter.mvp.TwitterModel
import com.rhino.socialfeed.ui.twitter.mvp.TwitterPresenter
import com.rhino.socialfeed.ui.twitter.mvp.TwitterView
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
@Module
class TwitterModule(private val fragment: TwitterFragment) {

    @Provides
    @TwitterFragmentScope
    fun provideActivity(): MainActivity = fragment.activity as MainActivity

    @Provides
    @TwitterFragmentScope
    fun provideModel(sessionManager: SessionManager): TwitterContract.Model = TwitterModel(
            fragment = fragment,
            sessionManager = sessionManager
    )

    @Provides
    @TwitterFragmentScope
    fun provideView(activity: MainActivity
    ): TwitterContract.View = TwitterView(activity = activity)

    @Provides
    @TwitterFragmentScope
    fun providePresenter(
            view: TwitterContract.View,
            model: TwitterContract.Model,
            sessionManager: SessionManager
    ): TwitterContract.Presenter =
            TwitterPresenter(view = view, model = model, sessionManager = sessionManager)

}