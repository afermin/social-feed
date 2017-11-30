package com.rhino.socialfeed.ui.splash

import android.os.Bundle
import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.ui.splash.di.DaggerSplashComponent
import com.rhino.socialfeed.ui.splash.di.SplashModule
import com.rhino.socialfeed.ui.splash.mvp.SplashContract
import javax.inject.Inject

class SplashActivity : RxActivity() {

    @Inject lateinit var view: SplashContract.View
    @Inject lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponent()
        setContentView(view.inflateLayout())

        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
    private fun initComponent() {
        DaggerSplashComponent.builder()
                .appComponent(SocialFeedApplication[this].component())
                .splashModule(SplashModule(this))
                .build()
                .inject(this)
    }
}
