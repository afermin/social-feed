package com.rhino.socialfeed.ui.splash.mvp

import com.rhino.socialfeed.common.mvp.MVPContract
import com.rhino.socialfeed.models.instagram.InstagramUser
import io.reactivex.Single

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class SplashContract {

    interface Model : MVPContract.Model {
        fun getInstagramSelf(): Single<InstagramUser>
        fun logoutInstagram()
        fun startMainActivity()
    }

    interface View : MVPContract.View

    interface Presenter : MVPContract.Presenter

}