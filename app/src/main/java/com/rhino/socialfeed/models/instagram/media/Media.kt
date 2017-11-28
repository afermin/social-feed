package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class Media {

    @Json(name = "data")
    var data: List<Datum>? = null

}
