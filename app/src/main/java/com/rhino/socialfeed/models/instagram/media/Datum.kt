package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class Datum {

    @Json(name = "comments")
    var comments: Comments? = null
    @Json(name = "caption")
    var caption: Caption? = null
    @Json(name = "likes")
    var likes: Likes? = null
    @Json(name = "link")
    var link: String? = null
    @Json(name = "user")
    var user: User? = null
    @Json(name = "created_time")
    var createdTime: String? = null
    @Json(name = "images")
    var images: Images? = null
    @Json(name = "type")
    var type: String? = null
    @Json(name = "filter")
    var filter: String? = null
    @Json(name = "id")
    var id: String? = null

}
