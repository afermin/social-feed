package com.rhino.socialfeed.ui.twitter.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.models.MyTwitterSession
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import com.twitter.sdk.android.core.TwitterSession
import io.reactivex.Observable

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class TwitterModel(val fragment: TwitterFragment, val sessionManager: SessionManager)
    : TwitterContract.Model {

    override fun getRxTwitterLogin(): Observable<TwitterSession> = fragment.rxTwitterLogin()

    override fun saveTwitterSession(twitterSession: TwitterSession) {
        val myTwitterSession = MyTwitterSession(twitterSession.authToken.token,
                twitterSession.authToken.secret, twitterSession.userName)
        sessionManager.twitterSession = myTwitterSession
    }

}