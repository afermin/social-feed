package com.rhino.socialfeed.ui.settings

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.socialfeed.ui.instagram.di.DaggerInstagramComponent
import com.rhino.socialfeed.ui.instagram.di.InstagramModule
import com.rhino.socialfeed.ui.instagram.mvp.InstagramContract
import com.rhino.socialfeed.ui.settings.di.DaggerSettingsComponent
import com.rhino.socialfeed.ui.settings.di.SettingsModule
import com.rhino.socialfeed.ui.settings.mvp.SettingsContract
import com.rhino.socialfeed.ui.settings.mvp.SettingsPresenter
import kotlinx.android.synthetic.main.fragment_twitter.*
import javax.inject.Inject

class SettingsFragment : Fragment() {

    @Inject lateinit var view: SettingsContract.View
    @Inject lateinit var presenter: SettingsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponent()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            view.inflateLayout(container)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        btnTwitterLogin.onActivityResult(requestCode, resultCode, data)
    }

    private fun initComponent() {
        DaggerSettingsComponent.builder()
                .appComponent(SocialFeedApplication[activity!!].component())
                .settingsModule(SettingsModule(this))
                .build()
                .inject(this)
    }

    companion object {
        fun newInstance(): SettingsFragment = SettingsFragment()
        val TAG = "TAG_${SettingsFragment::class.java.simpleName}"
    }


}
