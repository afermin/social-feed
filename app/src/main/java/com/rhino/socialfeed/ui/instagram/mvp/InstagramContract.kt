package com.rhino.socialfeed.ui.instagram.mvp

import com.rhino.socialfeed.common.mvp.MVPContract
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import io.reactivex.Observable

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class InstagramContract {

    interface Model : MVPContract.Model {

    }

    interface View : MVPContract.View {
        fun setLoginButtonVisibility(int: Int)
    }

    interface Presenter : MVPContract.Presenter

}