package com.khai.mycv.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CvResponse(
        @Json(name = "details") val details: Details?,
        @Json(name = "sections") val sections: List<Section?>?
) {
    @JsonClass(generateAdapter = true)
    data class Details(
            @Json(name = "address") val address: String?,
            @Json(name = "email") val email: String?,
            @Json(name = "mobile") val mobile: String?,
            @Json(name = "name") val name: String?,
            @Json(name = "pronouns") val pronouns: String?
    )

    @JsonClass(generateAdapter = true)
    data class Section(
            @Json(name = "data") val `data`: List<Data?>?,
            @Json(name = "profile") val profile: String?,
            @Json(name = "profile_image") val profileImage: String?,
            @Json(name = "project_details") val projectDetails: String?,
            @Json(name = "title") val title: String?, // About
            @Json(name = "type") val type: String? // about
    ) {
        @JsonClass(generateAdapter = true)
        data class Data(
                @Json(name = "achievements") val achievements: List<Achievement?>?,
                @Json(name = "degree") val degree: String?,
                @Json(name = "institution") val institution: String?,
                @Json(name = "period") val period: String?
        ) {
            @JsonClass(generateAdapter = true)
            class Achievement
        }
    }
}

