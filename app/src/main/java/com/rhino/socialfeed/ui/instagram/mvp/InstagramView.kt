package com.rhino.socialfeed.ui.instagram.mvp

import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import com.rhino.socialfeed.R
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.common.mvp.MVPView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_instagram.view.*
import kotlinx.android.synthetic.main.fragment_twitter.view.*

/**
 * Created by alexanderjosefermingomez on 11/24/17.
 */

class InstagramView(override val activity: RxActivity)
    : MVPView(activity), InstagramContract.View {

    override fun loadWebViewLogin() {
        webView.loadUrl("https://api.instagram.com/oauth/authorize/?client_id=b09363abd21c4ca8836f1b9a76fc8f6e&redirect_uri=http://www.kogimobile.com/android/socialfeed/redirect&response_type=token")
    }

    override fun setLoginButtonVisibility(visibility: Int) {
        btnTwitterLogin.visibility = visibility
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val view = FrameLayout.inflate(activity, R.layout.fragment_instagram, this)
        return view
    }

    override fun observableShouldOverrideUrlLoading(): Observable<WebResourceRequest> {
        return Observable.create { subscriber ->
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    subscriber.onNext(request)
                    return super.shouldOverrideUrlLoading(view, request)
                }
            }
        }
    }

}
