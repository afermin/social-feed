package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class Caption {

    @Json(name = "created_time")
    var createdTime: String? = null
    @Json(name = "text")
    var text: String? = null
    @Json(name = "from")
    var from: From? = null
    @Json(name = "id")
    var id: String? = null

}
