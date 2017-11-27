package com.rhino.socialfeed.ui.twitter.mvp

import android.view.View.GONE
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.twitter.sdk.android.core.TwitterSession


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class TwitterPresenter(
        override val view: TwitterContract.View,
        override val model: TwitterContract.Model, val sessionManager: SessionManager)
    : TwitterContract.Presenter {

    override fun onCreate() {
        model.getRxTwitterLogin().subscribe({ loginTwitterSuccess(it) })

        if(sessionManager.isTwitterSession) {
            showList()
        }

    }

    private fun loginTwitterSuccess(twitterSession: TwitterSession?) {
        model.saveTwitterSession(twitterSession!!)
        showList()
    }

    private fun showList() {
        view.setLoginButtonVisibility(GONE)
        view.setListAdapter()
    }

    override fun onDestroy() {

    }


}