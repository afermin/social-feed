package com.rhino.socialfeed.models.instagram

import com.squareup.moshi.Json

class Counts {

    @Json(name = "media")
    var media: Int? = null
    @Json(name = "follows")
    var follows: Int? = null
    @Json(name = "followed_by")
    var followedBy: Int? = null

}
