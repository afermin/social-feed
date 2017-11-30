package com.rhino.socialfeed.ui.main.mvp

import android.view.MenuItem
import com.rhino.socialfeed.R
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.settings.SettingsFragment
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
class MainPresenter(override val view: MainContract.View, override val model: MainContract.Model)
    : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        showTwitter()
        compositeDisposable.apply {
            add(view.observableNavigationView().subscribe { observeNavigationView(it) })
        }

    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    private fun observeNavigationView(menuItem: MenuItem?) {
        when (menuItem!!.itemId) {
            R.id.navTwitter -> showTwitter()
            R.id.navInstagram -> view.show(InstagramFragment.newInstance(), InstagramFragment.TAG)
            R.id.navSettings -> view.show(SettingsFragment.newInstance(), SettingsFragment.TAG)
        }
        view.setTitle(menuItem.title)
        view.closeDrawer()
    }

    private fun showTwitter() {
        view.show(TwitterFragment.newInstance(), TwitterFragment.TAG)
        view.setTitle(R.string.twitter)
    }

}