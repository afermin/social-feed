package com.rhino.socialfeed.ui.twitter

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhino.socialfeed.R
import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.socialfeed.ui.settings.mvp.SettingsPresenter
import com.rhino.socialfeed.ui.twitter.di.DaggerTwitterComponent
import com.rhino.socialfeed.ui.twitter.di.TwitterModule
import com.rhino.socialfeed.ui.twitter.mvp.TwitterContract
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterAuthClient
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_twitter.*
import javax.inject.Inject

class TwitterFragment : Fragment() {

    @Inject lateinit var view: TwitterContract.View
    @Inject lateinit var presenter: TwitterContract.Presenter

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

        val twitterAuthClient = TwitterAuthClient()
        if (twitterAuthClient.requestCode == requestCode && resultCode != AppCompatActivity.RESULT_CANCELED) {
            btnTwitterLogin.onActivityResult(requestCode, resultCode, data)
        }
        else {
            twitterAuthClient.cancelAuthorize()
        }
    }

    fun rxTwitterLogin(): Observable<TwitterSession> {
        return Observable.create { subscriber ->

            btnTwitterLogin.callback = object : Callback<TwitterSession>() {
                override fun failure(exception: TwitterException?) {
                    subscriber.onError(exception)
                }

                override fun success(result: Result<TwitterSession>?) {
                    Log.d("success", "twitter")
                    subscriber.onNext(result!!.data)
                }
            }
        }
    }


    private fun initComponent() {
        DaggerTwitterComponent.builder()
                .appComponent(SocialFeedApplication[activity!!].component())
                .twitterModule(TwitterModule(this))
                .build()
                .inject(this)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        fun newInstance(): TwitterFragment = TwitterFragment()

        val TAG = "TAG_${TwitterFragment::class.java.simpleName}"
    }


}
