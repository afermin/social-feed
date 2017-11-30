package com.rhino.socialfeed.ui.splash.mvp

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
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */

class SplashView(override val activity: RxActivity)
    : MVPView(activity), SplashContract.View {

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.activity_splash, this)
        return view
    }

}
