package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class Images {

    @Json(name = "low_resolution")
    var lowResolution: LowResolution? = null
    @Json(name = "thumbnail")
    var thumbnail: Thumbnail? = null
    @Json(name = "standard_resolution")
    var standardResolution: StandardResolution? = null

}
