package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class From {

    @Json(name = "username")
    var username: String? = null
    @Json(name = "full_name")
    var fullName: String? = null
    @Json(name = "type")
    var type: String? = null
    @Json(name = "id")
    var id: String? = null

}
