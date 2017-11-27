package com.rhino.socialfeed.models.tweet

import com.squareup.moshi.Json

class Url_ {

    @Json(name = "url")
    var url: String? = null
    @Json(name = "expanded_url")
    var expandedUrl: String? = null
    @Json(name = "display_url")
    var displayUrl: String? = null
    @Json(name = "indices")
    var indices: List<Int>? = null

}
