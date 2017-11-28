package com.rhino.socialfeed.ui.main.mvp

import android.support.v4.app.Fragment
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.support.design.widget.RxNavigationView
import com.rhino.socialfeed.common.ext.replace
import com.rhino.socialfeed.R
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.common.mvp.MVPView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.main_content.view.*

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */

class MainView(override val activity: RxActivity) : MVPView(activity), MainContract.View {

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.activity_main, this)



        return view
    }

    override fun replace(fragment: Fragment) {
        activity.supportFragmentManager.replace(R.id.flContent, fragment)
    }

    override fun observableNavigationView(): Observable<MenuItem> =
            RxNavigationView.itemSelections(navigationView)

    override fun closeDrawer() {
        drawerLayout.closeDrawers()
    }

    override fun setTitle(title: CharSequence) {
        toolbar.title = title
    }


}
