package com.rhino.socialfeed.ui.instagram.mvp

import android.webkit.WebResourceRequest
import com.rhino.socialfeed.common.mvp.MVPContract
import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.models.instagram.media.Datum
import com.rhino.socialfeed.models.instagram.media.Media
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/20/17.
 */


class InstagramContract {

    interface Model : MVPContract.Model {
        fun getSelf(): Single<InstagramUser>
        fun getMedia(): Single<Media>
        fun saveInstagramToken(accessToken: String)
    }

    interface View : MVPContract.View {
        fun loadWebViewLogin(url: String)
        fun setLoginButtonVisibility(int: Int)
        val observableReceiveError: Observable<Any>
        val observablePageStarted: Observable<String>
        val observableButton: Observable<Any>
        val observableSwipeRefresh: Observable<Any>
        fun setDataAdapter(data: List<Datum>?)
        fun setWebViewVisibility(visibility: Int)
        fun setFollowers(string: String)
        fun setFollowing(string: String)
        fun setPost(string: String)
        fun setImageProfile(string: String)
        fun setName(string: String)
        fun setUserName(string: String)
        fun setBio(string: String)
        fun setWebsite(string: String)
        fun setContentVisibility(int: Int)
        fun setRefresh(boolean: Boolean)
        fun setSwipeRefreshEnable(boolean: Boolean)
    }

    interface Presenter : MVPContract.Presenter {
        fun onHiddenChanged(hidden: Boolean)
    }

}