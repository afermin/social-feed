package com.rhino.socialfeed.ui.twitter.mvp

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.rhino.socialfeed.R
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.common.mvp.MVPView
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import kotlinx.android.synthetic.main.fragment_twitter.view.*

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */

class TwitterView(override val activity: RxActivity)
    : MVPView(activity), TwitterContract.View {

    override fun setLoginButtonVisibility(visibility: Int) {
        btnTwitterLogin.visibility = visibility
    }

    override fun setListAdapter(userTimeline: UserTimeline) {
        val adapter = TweetTimelineRecyclerViewAdapter.Builder(activity)
                .setTimeline(userTimeline).build()
        recyclerView.adapter = adapter
    }

    override fun removeViewRecycler() {
        recyclerView.removeAllViewsInLayout()

        //adapter.notifyItemRangeRemoved(0, adapter.itemCount)
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.fragment_twitter, this)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(activity)

        return view
    }

}
