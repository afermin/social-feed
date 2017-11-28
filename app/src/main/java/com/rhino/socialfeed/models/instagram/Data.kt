package com.rhino.socialfeed.models.instagram

import com.squareup.moshi.Json

class Data {

    @Json(name = "id")
    var id: String? = null
    @Json(name = "username")
    var username: String? = null
    @Json(name = "full_name")
    var fullName: String? = null
    @Json(name = "profile_picture")
    var profilePicture: String? = null
    @Json(name = "bio")
    var bio: String? = null
    @Json(name = "website")
    var website: String? = null
    @Json(name = "counts")
    var counts: Counts? = null

}
