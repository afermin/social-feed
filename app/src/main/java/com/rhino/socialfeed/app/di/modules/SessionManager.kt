package com.rhino.socialfeed.app.di.modules

import android.content.Context
import android.util.Log
import com.rhino.socialfeed.common.ext.saveString
import com.rhino.chronometer.app.di.AppScope
import com.rhino.socialfeed.app.di.AppQualifier
import com.rhino.socialfeed.models.MyInstagramSession
import com.rhino.socialfeed.models.MyTwitterSession
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

@AppScope
class SessionManager @Inject constructor(@AppQualifier context: Context, moshi: Moshi) {

    private val TAG = "TAG_${SessionManager::class.java.simpleName}"

    private val TWITTER_KEY = "twitter_key"
    private val INSTAGRAM_KEY = "instagram_key"
    private val PREFERENCES_TWITTER = "twitterPreferences"
    private val PREFERENCES_INSTAGRAM = "instagramPreferences"

    private val preferencesTwitter = context.getSharedPreferences(PREFERENCES_TWITTER, Context.MODE_PRIVATE)
    private val preferencesInstagram = context.getSharedPreferences(PREFERENCES_INSTAGRAM, Context.MODE_PRIVATE)

    private val twitterAdapter = moshi.adapter(MyTwitterSession::class.java)
    private val instagramAdapter = moshi.adapter(MyInstagramSession::class.java)

    private val twitterSubject = PublishSubject.create<MyTwitterSession>()
    private val instagramSubject = PublishSubject.create<MyInstagramSession>()

    val isTwitterSession: Boolean
        get() = preferencesTwitter.getString(TWITTER_KEY, "") != ""

    val isInstagramSession: Boolean
        get() = preferencesInstagram.getString(INSTAGRAM_KEY, "") != ""

    var twitterSession: MyTwitterSession?
        @Synchronized
        set(value) {
            if (value == null) {
                preferencesTwitter.edit().remove(TWITTER_KEY).apply()
            } else {
                preferencesTwitter.saveString(TWITTER_KEY, twitterAdapter.toJson(value))
                twitterSubject.onNext(value)
            }
        }
        get() {
            return try {
                twitterAdapter.fromJson(preferencesTwitter.getString(TWITTER_KEY, ""))
            } catch (error: Exception) {
                Log.e(TAG, error.message)
                error.printStackTrace()
                null
            }
        }

    var instagramSession: MyInstagramSession?
        @Synchronized
        set(value) {
            if (value == null) {
                preferencesInstagram.edit().remove(INSTAGRAM_KEY).apply()
            } else {
                preferencesInstagram.saveString(INSTAGRAM_KEY, instagramAdapter.toJson(value))
                instagramSubject.onNext(value)
            }
        }
        get() {
            try {
                return instagramAdapter.fromJson(preferencesInstagram.getString(INSTAGRAM_KEY, ""))
            } catch (error: Exception) {
                Log.e(TAG, error.message)
                error.printStackTrace()
                return null
            }
        }

    fun clearTwitter() = preferencesTwitter.edit().clear().apply()
    fun clearInstagram() = preferencesInstagram.edit().clear().apply()
}


