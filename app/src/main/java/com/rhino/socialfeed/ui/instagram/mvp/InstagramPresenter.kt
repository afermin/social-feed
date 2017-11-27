package com.rhino.socialfeed.ui.instagram.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class InstagramPresenter(
        override val view: InstagramContract.View,
        override val model: InstagramContract.Model, val sessionManager: SessionManager)
    : InstagramContract.Presenter {

    override fun onCreate() {


    }

    override fun onDestroy() {

    }


}