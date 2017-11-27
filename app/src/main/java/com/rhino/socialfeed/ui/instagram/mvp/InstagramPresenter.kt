package com.rhino.socialfeed.ui.instagram.mvp

import android.util.Log
import com.rhino.socialfeed.app.di.modules.SessionManager
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class InstagramPresenter(
        override val view: InstagramContract.View,
        override val model: InstagramContract.Model, val sessionManager: SessionManager)
    : InstagramContract.Presenter {

    private val TAG= "TAG_${InstagramPresenter::class.java.simpleName}"

    private val compositeDisposable = CompositeDisposable()

    private val REDIRECT_URI = "http://www.kogimobile.com/android/socialfeed/redirect"
    private val FAILURE_URL = "http://www.kogimobile.com/android/auth/failure"

    override fun onCreate() {

        view.observableShouldOverrideUrlLoading().subscribe({

            val url = it.toString()


                Log.d(TAG, "URL : " + url)
                if (url.startsWith(REDIRECT_URI)) {
            if (url.contains("access_token")) {
                val accessToken = url.split("#access_token=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                Log.d(TAG, "Instagram TOKEN: " + accessToken)
                //getConnectInstagramTask().execute(accessToken)
            } else if (url.contains("error_reason")) {
                val error = if (url.contains("user_denied")) "User denied access" else "Authentication failed"
                //Utils.notify(RuntimeException(error + " at " + TAG))
                /*Toast.makeText(act, String.format(getString(R.string.account_denied), "Instagram"),
                        Toast.LENGTH_SHORT).show()*/
                //finish()
            }
        } else if (url.startsWith(FAILURE_URL)) {/*
            // TODO: Alert unknown error
            finish()
            return true*/
        }
        }


        )
        view.loadWebViewLogin()


    }

    override fun onDestroy() {

    }
}