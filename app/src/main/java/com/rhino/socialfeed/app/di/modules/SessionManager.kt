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
    private val PREFERENCES_NAME = "sessionPreferences"

    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    private val twitterAdapter = moshi.adapter(MyTwitterSession::class.java)
    private val instagramAdapter = moshi.adapter(MyInstagramSession::class.java)

    private val twitterSubject = PublishSubject.create<MyTwitterSession>()
    private val instagramSubject = PublishSubject.create<MyInstagramSession>()

    val professionalObservable: Observable<MyTwitterSession> = twitterSubject
    val sessionObservable: Observable<MyInstagramSession> = instagramSubject

    val isTwitterSession: Boolean
        get() = preferences.getString(TWITTER_KEY, "") != ""

    val isInstagramSession: Boolean
        get() = preferences.getString(INSTAGRAM_KEY, "") != ""

    var twitterSession: MyTwitterSession?
        @Synchronized
        set(value) {
            if (value == null) {
                preferences.edit().remove(TWITTER_KEY).apply()
            }
            else {
                preferences.saveString(TWITTER_KEY, twitterAdapter.toJson(value))
                twitterSubject.onNext(value)
            }
        }
        get() {
            return try {
                twitterAdapter.fromJson(preferences.getString(TWITTER_KEY, ""))
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
                preferences.edit().remove(INSTAGRAM_KEY).apply()
            }
            else {
                preferences.saveString(INSTAGRAM_KEY, instagramAdapter.toJson(value))
                instagramSubject.onNext(value)
            }
        }
        get() {
            try {
                return instagramAdapter.fromJson(preferences.getString(INSTAGRAM_KEY, ""))
            } catch (error: Exception) {
                Log.e(TAG, error.message)
                error.printStackTrace()
                return null
            }
        }

    fun clear() = preferences.edit().clear().apply()
}


