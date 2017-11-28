package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class Location {

    @Json(name = "latitude")
    var latitude: Double? = null
    @Json(name = "longitude")
    var longitude: Double? = null
    @Json(name = "id")
    var id: String? = null
    @Json(name = "street_address")
    var streetAddress: String? = null
    @Json(name = "name")
    var name: String? = null

}
