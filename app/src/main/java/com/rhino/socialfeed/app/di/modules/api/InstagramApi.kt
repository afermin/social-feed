package com.rhino.socialfeed.app.di.modules.api

import com.rhino.socialfeed.models.instagram.InstagramUser
import com.rhino.socialfeed.models.instagram.media.Media
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface InstagramApi {

    @GET("v1/users/self/")
    fun getSelf(@Query("access_token") accessToken: String): Single<InstagramUser>

    @GET("v1/users/self/media/recent/")
    fun getMedia(@Query("access_token") accessToken: String): Single<Media>

}