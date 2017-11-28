package com.rhino.socialfeed.models.instagram.media

import com.squareup.moshi.Json

class Videos {

    @Json(name = "low_resolution")
    var lowResolution: LowResolution_? = null
    @Json(name = "standard_resolution")
    var standardResolution: StandardResolution_? = null
    @Json(name = "comments")
    var comments: Comments_? = null
    @Json(name = "caption")
    var caption: Any? = null
    @Json(name = "likes")
    var likes: Likes_? = null
    @Json(name = "link")
    var link: String? = null
    @Json(name = "created_time")
    var createdTime: String? = null
    @Json(name = "images")
    var images: Images_? = null
    @Json(name = "type")
    var type: String? = null
    @Json(name = "users_in_photo")
    var usersInPhoto: Any? = null
    @Json(name = "filter")
    var filter: String? = null
    @Json(name = "tags")
    var tags: List<Any>? = null
    @Json(name = "id")
    var id: String? = null
    @Json(name = "user")
    var user: User_? = null
    @Json(name = "location")
    var location: Any? = null

}
