package com.rhino.socialfeed.ui.twitter.di

import android.support.v4.app.Fragment
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.ui.main.MainActivity
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import com.rhino.socialfeed.ui.twitter.mvp.TwitterContract
import com.rhino.socialfeed.ui.twitter.mvp.TwitterModel
import com.rhino.socialfeed.ui.twitter.mvp.TwitterPresenter
import com.rhino.socialfeed.ui.twitter.mvp.TwitterView
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
    fun provideModel(): TwitterContract.Model = TwitterModel(
            fragment = fragment
    )

    @Provides
    @TwitterFragmentScope
    fun provideView():
            TwitterContract.View = TwitterView(activity = fragment.activity as RxActivity)

    @Provides
    @TwitterFragmentScope
    fun providePresenter(
            view: TwitterContract.View,
            model: TwitterContract.Model
    ): TwitterContract.Presenter = TwitterPresenter(view = view, model = model)
}