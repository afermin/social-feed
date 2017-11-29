package com.rhino.socialfeed.ui.twitter.mvp

import android.view.View.GONE
import android.view.View.VISIBLE
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.twitter.sdk.android.core.TwitterSession
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class TwitterPresenter(
        override val view: TwitterContract.View,
        override val model: TwitterContract.Model, val sessionManager: SessionManager)
    : TwitterContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        compositeDisposable.add(model.getRxTwitterLogin().subscribe({ loginTwitterSuccess(it) }))
        if (sessionManager.isTwitterSession) {
            showList()
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        if (!hidden && !sessionManager.isTwitterSession) {
            view.setLoginButtonVisibility(VISIBLE)
            view.removeViewRecycler()
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

}