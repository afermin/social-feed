package com.rhino.socialfeed.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.rhino.socialfeed.R
import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.ui.main.di.DaggerMainComponent
import com.rhino.socialfeed.ui.main.di.MainModule
import com.rhino.socialfeed.ui.main.mvp.MainContract
import javax.inject.Inject


class MainActivity : RxActivity() {

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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        val fragment = supportFragmentManager.findFragmentById(R.id.flContent)
        fragment?.onActivityResult(requestCode, resultCode, data)
    }

    private fun initComponent() {
        DaggerMainComponent.builder()
                .appComponent(SocialFeedApplication[this].component())
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

}
