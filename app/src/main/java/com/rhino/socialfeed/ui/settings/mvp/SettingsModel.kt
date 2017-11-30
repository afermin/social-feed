package com.rhino.socialfeed.ui.settings.mvp

import com.rhino.socialfeed.app.di.modules.SessionManager
import com.twitter.sdk.android.core.TwitterCore

/**
 * Created by Alexander Fermin (alexfer06@gmail.com) on 11/24/17.
 */
class SettingsModel(val sessionManager: SessionManager)
    : SettingsContract.Model {

    override fun logoutTwitter() {
        sessionManager.clearTwitter()
        TwitterCore.getInstance().sessionManager.clearActiveSession()
    }

    override fun logoutInstagram() {
        sessionManager.clearInstagram()
    }


}