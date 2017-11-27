package com.rhino.socialfeed.ui.twitter.mvp

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.rhino.socialfeed.R
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.common.mvp.MVPView
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import kotlinx.android.synthetic.main.fragment_twitter.view.*

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */

class TwitterView(override val activity: RxActivity, val adapter: TweetTimelineListAdapter)
    : MVPView(activity), TwitterContract.View {

    override fun setLoginButtonVisibility(visibility: Int) {
        btnTwitterLogin.visibility = visibility
    }

    override fun setListAdapter() {
        recycler.adapter = adapter
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.fragment_twitter, this)
        return view
    }

}
