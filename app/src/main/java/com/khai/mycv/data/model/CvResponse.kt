package com.khai.mycv.data.model


import com.khai.mycv.data.adapter.AboutType
import com.khai.mycv.data.adapter.MediaType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class CvResponse(
    @Json(name = "home") val home: Home,
    @Json(name = "about") val about: List<About>,
    @Json(name = "education") val education: Education,
    @Json(name = "experience") val experience: Experience,
    @Json(name = "fun_facts") val funFacts: FunFacts
) : Serializable {
    @JsonClass(generateAdapter = true)
    data class Home(
        @Json(name = "title") val title: String,
        @Json(name = "greeting") val greeting: String,
        @Json(name = "intro_title") val introTitle: String,
        @Json(name = "intro_body") val introBody: List<String>
    ) : Serializable

    @JsonClass(generateAdapter = true)
    data class About(
        @Json(name = "type") val type: AboutType?,
        @Json(name = "title") val title: String?,
        @Json(name = "profile") val profile: List<String>?,
        @Json(name = "project_link") val projectLink: String?,
        @Json(name = "project_details") val projectDetails: List<String>?,
        @Json(name = "name") val name: String?,
        @Json(name = "address") val address: String?,
        @Json(name = "pronouns") val pronouns: String?,
        @Json(name = "mobile") val mobile: String?,
        @Json(name = "email") val email: String?
    ) : Serializable

    @JsonClass(generateAdapter = true)
    data class Education(
        @Json(name = "title") val title: String,
        @Json(name = "data") val data: List<EducationData>
    ) : Serializable {
        @JsonClass(generateAdapter = true)
        data class EducationData(
            @Json(name = "degree") val degree: String,
            @Json(name = "period") val period: String?,
            @Json(name = "institution") val institution: String,
            @Json(name = "details") val details: List<String>?
        ) : Serializable
    }

    @JsonClass(generateAdapter = true)
    data class Experience(
        @Json(name = "title") val title: String
    ) : Serializable

    @JsonClass(generateAdapter = true)
    data class FunFacts(
        @Json(name = "title") val title: String,
        @Json(name = "data") val data: List<FunFactsData>
    ) : Serializable {
        @JsonClass(generateAdapter = true)
        data class FunFactsData(
            @Json(name = "type") val type: MediaType,
            @Json(name = "title") val title: String?,
            @Json(name = "body") val body: String?,
            @Json(name = "video_url") val videoUrl: String?,
            @Json(name = "img_src") val imgSrc: String?,

        )
    }



}