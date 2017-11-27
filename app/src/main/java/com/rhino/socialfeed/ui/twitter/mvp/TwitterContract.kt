package com.rhino.socialfeed.ui.twitter.mvp

import com.rhino.socialfeed.common.mvp.MVPContract
import com.twitter.sdk.android.core.TwitterSession
import io.reactivex.Observable

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class TwitterContract {

    interface Model : MVPContract.Model {
        fun getRxTwitterLogin(): Observable<TwitterSession>
    }

    interface View : MVPContract.View

    interface Presenter : MVPContract.Presenter {
    }

}