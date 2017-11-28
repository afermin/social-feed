package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class Images_ {

    @Json(name = "low_resolution")
    var lowResolution: LowResolution__? = null
    @Json(name = "thumbnail")
    var thumbnail: Thumbnail_? = null
    @Json(name = "standard_resolution")
    var standardResolution: StandardResolution__? = null

}
