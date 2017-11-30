package com.rhino.socialfeed.ui.main.di

import android.content.Context
import com.rhino.socialfeed.ui.main.MainActivity
import com.rhino.socialfeed.ui.main.mvp.MainContract
import com.rhino.socialfeed.ui.main.mvp.MainModel
import com.rhino.socialfeed.ui.main.mvp.MainPresenter
import com.rhino.socialfeed.ui.main.mvp.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
@Module
class MainModule(private val activity: MainActivity) {

    @Provides
    @MainScope
    fun provideActivity(): MainActivity = activity

    @Provides
    @MainScope
    fun provideModel(): MainContract.Model = MainModel(
            activity = activity
    )

    @Provides
    @MainScope
    fun provideView(activity: MainActivity):
            MainContract.View = MainView(activity = activity)

    @Provides
    @MainScope
    fun providePresenter(
            view: MainContract.View,
            model: MainContract.Model
    ): MainContract.Presenter = MainPresenter(view = view, model = model)

    @Provides
    @MainScope
    fun provideContext(): Context = activity

}