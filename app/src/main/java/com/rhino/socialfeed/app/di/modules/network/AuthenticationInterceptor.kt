package com.rhino.socialfeed.app.di.modules.network

import android.content.Context
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.AppQualifier
import com.rhino.socialfeed.app.di.modules.SessionManager
import com.rhino.socialfeed.ui.splash.SplashActivity
import okhttp3.Interceptor
import okhttp3.Response
import org.jetbrains.anko.intentFor
import javax.inject.Inject

@AppScope
class TwitterAuthenticationInterceptor @Inject constructor(
        @AppQualifier val context: Context,
        val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {

        val request = chain
                ?.request()
                ?.newBuilder()
                ?.addHeader("Authorization", "Bearer ${sessionManager.twitterSession}")
                ?.build()

        val response = chain?.proceed(request)
        val code = response?.code()

        if (code == 401 || code == 403) {
            context.apply { startActivity(intentFor<SplashActivity>()) }
        }

        return response
    }
}

@AppScope
class InstagramAuthenticationInterceptor @Inject constructor(
        @AppQualifier val context: Context,
        val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {

        val request = chain
                ?.request()
                ?.newBuilder()
                ?.addHeader("Authorization", "Bearer ${sessionManager.instagramSession}")
                ?.build()

        val response = chain?.proceed(request)
        val code = response?.code()

        if (code == 401 || code == 403) {
            context.apply { startActivity(intentFor<SplashActivity>()) }
        }

        return response
    }
}