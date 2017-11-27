package com.rhino.socialfeed.ui.instagram

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
import kotlinx.android.synthetic.main.fragment_twitter.*
import javax.inject.Inject

class InstagramFragment : Fragment() {

    /*https://gist.github.com/j4rs/8963688*/

    @Inject lateinit var view: InstagramContract.View
    @Inject lateinit var presenter: InstagramContract.Presenter

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
        DaggerInstagramComponent.builder()
                .appComponent(SocialFeedApplication[activity!!].component())
                .instagramModule(InstagramModule(this))
                .build()
                .inject(this)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        fun newInstance(): InstagramFragment = InstagramFragment()
    }


}
