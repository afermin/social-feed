package com.rhino.socialfeed.ui.main.mvp

import android.view.MenuItem
import com.rhino.socialfeed.R
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.settings.SettingsFragment
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class MainPresenter(override val view: MainContract.View, override val model: MainContract.Model)
    : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        //view.show(TwitterFragment.newInstance(), TwitterFragment.TAG)
        compositeDisposable.apply {
            add(view.observableNavigationView().subscribe { observeNavigationView(it) })
        }
    }

    private fun observeNavigationView(menuItem: MenuItem?) {
        when (menuItem!!.itemId) {
            R.id.navTwitter -> view.show(TwitterFragment.newInstance(), TwitterFragment.TAG)
            R.id.navInstagram -> view.show(InstagramFragment.newInstance(), InstagramFragment.TAG)
            R.id.navSettings -> view.show(SettingsFragment.newInstance(), SettingsFragment.TAG)
        }
        view.setTitle(menuItem.title)
        view.closeDrawer()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }


}