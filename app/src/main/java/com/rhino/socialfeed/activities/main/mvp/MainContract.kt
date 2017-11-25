package com.rhino.socialfeed.activities.main.mvp

import android.view.ViewGroup

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */


class MainContract {
    interface Model {
    }

    interface View {
        fun inflateLayout(container: ViewGroup? = null): android.view.View?
    }

    interface Presenter {
        val view: View
        val model: Model
        fun onCreate()
        fun onDestroy()
    }
}