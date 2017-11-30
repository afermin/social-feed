package com.rhino.socialfeed.ui.splash.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.app.di.modules.api.InstagramApi
import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.ui.main.MainActivity
import com.rhino.socialfeed.ui.splash.SplashActivity
import io.reactivex.Single
import org.jetbrains.anko.intentFor

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
class SplashModel(
        val activity: SplashActivity,
        val sessionManager: SessionManager,
        private val instagramApi: InstagramApi)
    : SplashContract.Model {

    override fun startMainActivity() {
        activity.startActivity(activity.intentFor<MainActivity>())
        activity.finish()
    }

    override fun getInstagramSelf():
            Single<InstagramUser> = instagramApi.getSelf(sessionManager.instagramSession!!.accessToken)

    override fun logoutInstagram() {
        sessionManager.clearInstagram()
        activity.finish()
    }


}