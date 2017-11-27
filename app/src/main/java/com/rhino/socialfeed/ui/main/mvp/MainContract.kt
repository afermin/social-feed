package com.rhino.socialfeed.ui.main.mvp

import android.support.v4.app.Fragment
import com.rhino.socialfeed.common.mvp.MVPContract

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class MainContract {

    interface Model : MVPContract.Model

    interface View : MVPContract.View {
        fun replace(fragment: Fragment)
    }

    interface Presenter : MVPContract.Presenter

}