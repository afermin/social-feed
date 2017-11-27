package com.rhino.socialfeed.models.tweet

import com.squareup.moshi.Json

class Url {

    @Json(name = "urls")
    var urls: List<Url_>? = null

}
