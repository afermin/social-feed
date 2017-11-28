package com.rhino.socialfeed.ui.settings.mvp

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.rhino.socialfeed.R
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.common.mvp.MVPView

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */

class SettingsView(override val activity: RxActivity)
    : MVPView(activity), SettingsContract.View {

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.fragment_settings, this)
        return view
    }

}
