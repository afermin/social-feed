package com.rhino.socialfeed.ui.splash.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class SplashPresenter(
        override val view: SplashContract.View,
        override val model: SplashContract.Model,
        val sessionManager: SessionManager)
    : SplashContract.Presenter {

    private val TAG = "TAG_${SplashPresenter::class.java.simpleName}"

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        if (sessionManager.isInstagramSession) {
            compositeDisposable.apply {
                add(model.getInstagramSelf().subscribe(
                        { model.startMainActivity() },
                        {
                            model.logoutInstagram()
                            model.startMainActivity()
                        })
                )
            }
        } else {
            model.startMainActivity()
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

}