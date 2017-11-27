package com.rhino.socialfeed.ui.twitter.mvp

import com.rhino.socialfeed.ui.twitter.TwitterFragment
import com.twitter.sdk.android.core.TwitterSession
import io.reactivex.Observable

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class TwitterModel(val fragment: TwitterFragment) : TwitterContract.Model {

    override fun getRxTwitterLogin(): Observable<TwitterSession> = fragment.rxTwitterLogin()

}