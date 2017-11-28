package com.rhino.socialfeed.models.instagram

import com.squareup.moshi.Json

class InstagramUser {

    @Json(name = "data")
    var data: Data? = null

}
