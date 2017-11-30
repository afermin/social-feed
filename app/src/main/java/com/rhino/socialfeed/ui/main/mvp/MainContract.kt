package com.rhino.socialfeed.ui.main.mvp

import android.support.v4.app.Fragment
import android.view.MenuItem
import com.rhino.socialfeed.common.mvp.MVPContract
import io.reactivex.Observable

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/20/17.
 */


class MainContract {

    interface Model : MVPContract.Model

    interface View : MVPContract.View {
        fun show(fragment: Fragment, tag: String)
        fun observableNavigationView(): Observable<MenuItem>
        fun closeDrawer()
        fun setTitle(title: CharSequence)
        fun setTitle(title: Int)
    }

    interface Presenter : MVPContract.Presenter

}