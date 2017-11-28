package com.rhino.socialfeed.ui.settings.mvp

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

        }

        if (sessionManager.isInstagramSession) {
        }
    }

    override fun onDestroy() {

    }
}