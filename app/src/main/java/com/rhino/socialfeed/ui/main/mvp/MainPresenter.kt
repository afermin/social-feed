package com.rhino.socialfeed.ui.main.mvp

import com.rhino.socialfeed.ui.twitter.TwitterFragment


/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class MainPresenter(override val view: MainContract.View, override val model: MainContract.Model) :
        MainContract.Presenter {

    override fun onCreate() {
        view.replace(TwitterFragment.newInstance())
    }

    override fun onDestroy() {

    }


}