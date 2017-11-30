package com.rhino.socialfeed.ui.settings.mvp

import android.view.View
import com.rhino.socialfeed.R
import com.rhino.socialfeed.app.di.modules.SessionManager
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
class SettingsPresenter(
        override val view: SettingsContract.View,
        override val model: SettingsContract.Model,
        val sessionManager: SessionManager)
    : SettingsContract.Presenter {

    private val TAG = "TAG_${SettingsPresenter::class.java.simpleName}"

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        compositeDisposable.apply {
            add(view.observableTwitter.subscribe {
                model.logoutTwitter()
                view.setTwitterEnable(false)
                view.showToast(R.string.twitter_logout_success)
            })
            add(view.observableInstagram.subscribe {
                model.logoutInstagram()
                view.setInstagramEnable(false)
                view.showToast(R.string.instagram_logout_success)
            })
        }

        checkSessions()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        if (!hidden) {
            checkSessions()
        }
    }

    private fun checkSessions() {
        view.setTwitterEnable(sessionManager.isTwitterSession)
        view.setInstagramEnable(sessionManager.isInstagramSession)
    }

}