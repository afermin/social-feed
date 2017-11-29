package com.rhino.socialfeed.ui.settings.mvp

import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.view.RxView
import com.rhino.socialfeed.R
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.common.mvp.MVPView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_settings.view.*

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */

class SettingsView(override val activity: RxActivity)
    : MVPView(activity), SettingsContract.View {

    override val observableTwitter: Observable<Any> by lazy { RxView.clicks(tvTwitter) }

    override val observableInstagram: Observable<Any> by lazy { RxView.clicks(tvInstagram) }

    override fun setTwitterEnable(boolean: Boolean) {
        tvTwitter.isEnabled = boolean
        tvTwitter.setTextColor(ContextCompat.getColor(activity,
                if (boolean) R.color.primaryText else R.color.secondaryText))
    }

    override fun setInstagramEnable(boolean: Boolean) {
        tvInstagram.isEnabled = boolean
        tvInstagram.setTextColor(ContextCompat.getColor(activity,
                if (boolean) R.color.primaryText else R.color.secondaryText))
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.fragment_settings, this)
        return view
    }

}
