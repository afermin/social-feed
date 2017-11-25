package com.rhino.socialfeed.activities.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rhino.socialfeed.activities.main.di.DaggerMainComponent
import com.rhino.socialfeed.activities.main.di.MainModule
import com.rhino.socialfeed.activities.main.mvp.MainContract
import com.rhino.socialfeed.app.SocialFeedApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var view: MainContract.View
    @Inject lateinit var presenter: MainContract.Presenter

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
        DaggerMainComponent.builder()
                .appComponent(SocialFeedApplication[this].component())
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

}
