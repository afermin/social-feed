package com.rhino.socialfeed.ui.instagram.mvp

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

class InstagramView(override val activity: RxActivity)
    : MVPView(activity), InstagramContract.View {

    override fun setLoginButtonVisibility(visibility: Int) {
        btnTwitterLogin.visibility = visibility
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.fragment_instagram, this)
        return view
    }

}
