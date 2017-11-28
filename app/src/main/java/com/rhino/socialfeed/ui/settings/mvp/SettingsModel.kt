package com.rhino.socialfeed.ui.settings.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.app.di.modules.api.InstagramApi
import com.rhino.socialfeed.models.MyInstagramSession
import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.models.instagram.media.Media
import com.rhino.socialfeed.ui.instagram.InstagramFragment
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */
class SettingsModel(val sessionManager: SessionManager)
    : SettingsContract.Model {



}