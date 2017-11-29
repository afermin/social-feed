package com.rhino.socialfeed.ui.settings.mvp

import android.view.View
import com.rhino.socialfeed.app.di.modules.SessionManager
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by alexanderjosefermingomez on 11/24/17.
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
            })
            add(view.observableInstagram.subscribe {
                model.logoutInstagram()
                view.setInstagramEnable(false)
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