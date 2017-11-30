package com.rhino.socialfeed.ui.twitter.mvp

import com.rhino.socialfeed.common.mvp.MVPContract
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import io.reactivex.Observable

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class TwitterContract {

    interface Model : MVPContract.Model {
        fun getRxTwitterLogin(): Observable<TwitterSession>
        fun saveTwitterSession(twitterSession: TwitterSession)
    }

    interface View : MVPContract.View {
        fun setListAdapter(userTimeline: UserTimeline)
        fun setLoginButtonVisibility(int: Int)
        fun removeViewRecycler()
    }

    interface Presenter : MVPContract.Presenter {
        fun onHiddenChanged(hidden: Boolean)
    }

}