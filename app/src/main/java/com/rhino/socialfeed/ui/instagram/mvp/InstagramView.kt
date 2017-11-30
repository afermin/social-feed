package com.rhino.socialfeed.ui.instagram.mvp

import android.graphics.Bitmap
import android.support.v7.widget.GridLayoutManager
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout
import com.jakewharton.rxbinding2.view.RxView
import com.rhino.socialfeed.R
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.common.mvp.MVPView
import com.rhino.socialfeed.models.instagram.media.Datum
import com.rhino.socialfeed.ui.instagram.InstagramAdapter
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.fragment_instagram.view.*
import kotlinx.android.synthetic.main.instagram_content.view.*
import kotlinx.android.synthetic.main.instagram_header.view.*

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */

class InstagramView(override val activity: RxActivity,
                    val adapter: InstagramAdapter,
                    val picasso: Picasso)
    : MVPView(activity), InstagramContract.View {


    private var subjectPageStarted: PublishSubject<String>? = null
    override val observablePageStarted: Observable<String> by lazy {
        subjectPageStarted = PublishSubject.create()
        subjectPageStarted as Observable<String>
    }

    private var subjectReceiveError: PublishSubject<Any>? = null
    override val observableReceiveError: Observable<Any> by lazy {
        subjectReceiveError = PublishSubject.create()
        subjectReceiveError as Observable<Any>
    }

    override val observableButton: Observable<Any> by lazy { RxView.clicks(btnLogin) }

    override val observableSwipeRefresh: Observable<Any> by lazy { RxSwipeRefreshLayout.refreshes(swipeRefresh) }

    override fun loadWebViewLogin() {
        webView.loadUrl("https://www.instagram.com/oauth/authorize/?client_id=2a5464070558449c81adc30ce410887c&redirect_uri=http://nucleos.io/&response_type=token")
    }

    override fun setContentVisibility(int: Int) {
        content.visibility = int
    }

    override fun setLoginButtonVisibility(visibility: Int) {
        btnLogin.visibility = visibility
    }

    override fun setWebViewVisibility(visibility: Int) {
        webView.visibility = visibility
    }

    override fun setDataAdapter(data: List<Datum>?) {
        this.activity.runOnUiThread { adapter.setData(data) }
    }

    override fun setFollowers(string: String) {
        tvFollowersNumber.text = string
    }

    override fun setFollowing(string: String) {
        tvFollowingNumber.text = string
    }

    override fun setPost(string: String) {
        tvPostNumber.text = string
    }

    override fun setImageProfile(url: String) {
        picasso.load(url).transform(CropCircleTransformation()).into(ivImageProfile)
    }

    override fun setName(string: String) {
        tvName.text = string
    }

    override fun setUserName(string: String) {
        tvUserName.text = string
    }

    override fun setBio(string: String) {
        tvBio.text = string
        tvBio.visibility = if (TextUtils.isEmpty(string)) View.GONE else View.VISIBLE
    }

    override fun setWebsite(string: String) {
        tvWebsite.text = string
        tvWebsite.visibility = if (TextUtils.isEmpty(string)) View.GONE else View.VISIBLE
    }

    override fun setRefresh(boolean: Boolean) {
        swipeRefresh.isRefreshing = boolean
    }

    override fun setSwipeRefreshEnable(boolean: Boolean) {
        swipeRefresh.isEnabled = boolean
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.fragment_instagram, this)
        recyclerView?.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(activity, 3)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.isNestedScrollingEnabled = false

        recyclerView.adapter = adapter

        webView.webViewClient = object : WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                subjectPageStarted?.onNext(url)
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                Log.d("TAG", "onReceivedError")
                subjectReceiveError?.onNext(Any())
            }

        }

        return view
    }

}
