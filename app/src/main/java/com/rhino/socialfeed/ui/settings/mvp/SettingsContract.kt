package com.rhino.socialfeed.ui.settings.mvp

import com.rhino.socialfeed.common.mvp.MVPContract
import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.models.instagram.media.Datum
import com.rhino.socialfeed.models.instagram.media.Media
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class SettingsContract {

    interface Model : MVPContract.Model {
        fun logoutTwitter()
        fun logoutInstagram()
    }

    interface View : MVPContract.View {
        val observableTwitter: Observable<Any>
        val observableInstagram: Observable<Any>
        fun setInstagramEnable(boolean: Boolean)
        fun setTwitterEnable(boolean: Boolean)
    }

    interface Presenter : MVPContract.Presenter

}