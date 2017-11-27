package com.rhino.socialfeed.ui.instagram.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.models.MyTwitterSession
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import com.rhino.socialfeed.ui.twitter.TwitterFragment
import com.twitter.sdk.android.core.TwitterSession
import io.reactivex.Observable

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class InstagramModel(val fragment: InstagramFragment, val sessionManager: SessionManager)
    : InstagramContract.Model {


}