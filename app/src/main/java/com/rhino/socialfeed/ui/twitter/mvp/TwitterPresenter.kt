package com.rhino.socialfeed.ui.twitter.mvp

import android.util.Log
import com.twitter.sdk.android.core.TwitterSession

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class TwitterPresenter(
        override val view: TwitterContract.View,
        override val model: TwitterContract.Model)
    : TwitterContract.Presenter {

    override fun onCreate() {
        model.getRxTwitterLogin().subscribe({loginTwitterSuccess(it)})
    }

    private fun loginTwitterSuccess(twitterSession: TwitterSession?) {


    }

    override fun onDestroy() {

    }


}