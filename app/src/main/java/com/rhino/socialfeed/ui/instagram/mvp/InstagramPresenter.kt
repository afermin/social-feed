package com.rhino.socialfeed.ui.instagram.mvp

import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import com.rhino.socialfeed.R
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.models.instagram.media.Media
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class InstagramPresenter(
        override val view: InstagramContract.View,
        override val model: InstagramContract.Model,
        val sessionManager: SessionManager)
    : InstagramContract.Presenter {

    private val TAG = "TAG_${InstagramPresenter::class.java.simpleName}"

    private val compositeDisposable = CompositeDisposable()

    private val REDIRECT_URI = "http://nucleos.io/"
    private val FAILURE_URL = "http://nucleos.io/failure"

    override fun onCreate() {

        compositeDisposable.apply {
            add(view.observableButton.subscribe { loadWebView() })
            add(view.observablePageStarted.subscribe { pageStarted(it) })
            add(view.observableSwipeRefresh.subscribe { getInstagramData() })
        }

        if (sessionManager.isInstagramSession) {
            loadInstagramData(sessionManager.instagramSession!!.accessToken)
        } else {
            view.setContentVisibility(GONE)
            view.setSwipeRefreshEnable(false)
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    private fun pageStarted(url: String) {
        Log.d(TAG, "URL : " + url)
        if (url.startsWith(REDIRECT_URI)) {
            if (url.contains("access_token")) {
                val accessToken = url.split("#access_token=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                Log.d(TAG, "Instagram TOKEN: " + accessToken)
                loadInstagramData(accessToken)

            } else if (url.contains("error_reason")) {
                val error = if (url.contains("user_denied")) "User denied access" else "Authentication failed"
                Log.d(TAG, error)
                view.showToast(R.string.account_denied)
                view.loadWebViewLogin()
            }
        } else if (url.startsWith(FAILURE_URL)) {
            view.showToast(R.string.error)
        }
    }

    private fun loadWebView() {
        view.loadWebViewLogin()
        view.setLoginButtonVisibility(GONE)
        view.setWebViewVisibility(VISIBLE)
    }

    private fun loadInstagramData(accessToken: String) {
        model.saveInstagramToken(accessToken)
        getInstagramData()
        view.setSwipeRefreshEnable(true)
        view.setRefresh(true)
        view.setContentVisibility(VISIBLE)
        view.setWebViewVisibility(GONE)
        view.setLoginButtonVisibility(GONE)
    }

    private fun getInstagramData() {
        compositeDisposable.add(
                Single.zip(model.getSelf()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()),
                        model.getMedia()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()),
                        BiFunction<InstagramUser, Media, Any> { instagramUser, media ->
                            Log.d(TAG, "getInstagramData")
                            setInstagramUser(instagramUser)
                            view.setDataAdapter(media.data)
                            view.setRefresh(false)
                        })
                        .doOnError {
                            view.setRefresh(false)
                            view.showToast(R.string.error)
                        }
                        .subscribe()
        )
    }

    private fun setInstagramUser(user: InstagramUser) {
        view.setImageProfile(user.data!!.profilePicture!!)
        view.setName(user.data!!.fullName!!)
        view.setUserName("@" + user.data!!.username!!)
        view.setPost(user.data!!.counts!!.media.toString())
        view.setFollowers(user.data!!.counts!!.follows.toString())
        view.setFollowing(user.data!!.counts!!.followedBy.toString())
        view.setBio(user.data!!.bio!!)
        view.setWebsite(user.data!!.website!!)
    }
}