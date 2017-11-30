package com.rhino.socialfeed.ui.instagram.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.app.di.modules.api.InstagramApi
import com.rhino.socialfeed.models.MyInstagramSession
import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.models.instagram.media.Media
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
class InstagramModel(val fragment: InstagramFragment,
                     val sessionManager: SessionManager,
                     val instagramApi: InstagramApi)
    : InstagramContract.Model {

    override fun saveInstagramToken(accessToken: String) {
        sessionManager.instagramSession = MyInstagramSession(accessToken)
    }

    override fun getSelf(): Single<InstagramUser> = instagramApi.getSelf(sessionManager.instagramSession!!.accessToken)

    override fun getMedia(): Single<Media> = instagramApi.getMedia(sessionManager.instagramSession!!.accessToken)

}