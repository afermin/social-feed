package com.rhino.socialfeed.ui.instagram.mvp

import com.rhino.socialfeed.common.mvp.MVPContract
import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.models.instagram.media.Datum
import com.rhino.socialfeed.models.instagram.media.Media
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class InstagramContract {

    interface Model : MVPContract.Model {
        fun getSelf(): Single<InstagramUser>
        fun getMedia(): Single<Media>
        fun saveInstagramToken(accessToken: String)
    }

    interface View : MVPContract.View {
        fun loadWebViewLogin()
        fun setLoginButtonVisibility(int: Int)
        val observablePageStarted: Observable<String>
        val observableButton: Observable<Any>
        fun setDataAdapter(data: List<Datum>?)
        fun setWebViewVisibility(visibility: Int)
        fun setFollowers(string: String)
        fun setFollowing(string: String)
        fun setPost(string: String)
        fun setImageProfile(string: String)
        fun setName(string: String)
        fun setUserName(string: String)
    }

    interface Presenter : MVPContract.Presenter

}