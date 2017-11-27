package com.rhino.socialfeed.models.tweet

import com.squareup.moshi.Json

class Description {

    @Json(name = "urls")
    var urls: List<Any>? = null

}
