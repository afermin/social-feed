package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class User {

    @Json(name = "username")
    var username: String? = null
    @Json(name = "profile_picture")
    var profilePicture: String? = null
    @Json(name = "id")
    var id: String? = null

}
