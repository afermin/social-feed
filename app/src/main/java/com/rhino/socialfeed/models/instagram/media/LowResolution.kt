package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class LowResolution {

    @Json(name = "url")
    var url: String? = null
    @Json(name = "width")
    var width: Int? = null
    @Json(name = "height")
    var height: Int? = null

}
