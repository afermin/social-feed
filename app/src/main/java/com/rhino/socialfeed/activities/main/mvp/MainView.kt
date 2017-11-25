package com.rhino.socialfeed.activities.main.mvp

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.rhino.socialfeed.R
import com.rhino.socialfeed.activities.main.MainActivity

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */

class MainView(val activity: MainActivity) : FrameLayout(activity), MainContract.View {
    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.activity_main, this)
        return view
    }
}
