package com.rhino.socialfeed.models.tweet

import com.squareup.moshi.Json

class Tweet {

    @Json(name = "created_at")
    var createdAt: String? = null
    @Json(name = "id")
    var id: Int? = null
    @Json(name = "id_str")
    var idStr: String? = null
    @Json(name = "text")
    var text: String? = null
    @Json(name = "truncated")
    var truncated: Boolean? = null
    @Json(name = "user")
    var user: User? = null

}
