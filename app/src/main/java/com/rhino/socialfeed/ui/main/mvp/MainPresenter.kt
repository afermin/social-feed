package com.rhino.socialfeed.ui.main.mvp

import android.view.MenuItem
import com.rhino.socialfeed.R
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class MainPresenter(override val view: MainContract.View, override val model: MainContract.Model) :
        MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        view.replace(TwitterFragment.newInstance())

        compositeDisposable.apply {
            add(view.observableNavigationView().subscribe { observeNavigationView(it) })
        }
    }

    private fun observeNavigationView(menuItem: MenuItem?) {
        when (menuItem!!.itemId) {
            R.id.navTwitter -> view.replace(TwitterFragment.newInstance())
            R.id.navInstagram -> view.replace(InstagramFragment.newInstance())
            R.id.navSettings -> view.replace(InstagramFragment.newInstance())
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }


}