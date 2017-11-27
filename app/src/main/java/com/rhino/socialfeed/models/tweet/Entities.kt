package com.rhino.socialfeed.models.tweet

import com.squareup.moshi.Json

class Entities {

    @Json(name = "url")
    var url: Url? = null
    @Json(name = "description")
    var description: Description? = null

}
