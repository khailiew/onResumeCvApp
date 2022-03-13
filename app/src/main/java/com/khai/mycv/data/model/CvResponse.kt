package com.khai.mycv.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CvResponse(
    @Json(name = "details")
    val details: Details,
    @Json(name = "sections")
    val sections: Sections
) {
    @JsonClass(generateAdapter = true)
    data class Details(
        @Json(name = "address")
        val address: String,
        @Json(name = "email")
        val email: String,
        @Json(name = "mobile")
        val mobile: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "pronouns")
        val pronouns: String
    )

    @JsonClass(generateAdapter = true)
    data class Sections(
        @Json(name = "about")
        val about: About,
        @Json(name = "education")
        val education: Education,
        @Json(name = "experience")
        val experience: Experience,
        @Json(name = "fun_facts")
        val funFacts: FunFacts
    ) {
        @JsonClass(generateAdapter = true)
        data class About(
            @Json(name = "intro_body")
            val introBody: List<String>,
            @Json(name = "intro_title")
            val introTitle: String,
            @Json(name = "profile")
            val profile: List<String>,
            @Json(name = "profile_image")
            val profileImage: String,
            @Json(name = "project_details")
            val projectDetails: List<String>,
            @Json(name = "title")
            val title: String // About
        )

        @JsonClass(generateAdapter = true)
        data class Education(
            @Json(name = "data")
            val `data`: List<Data>,
            @Json(name = "title")
            val title: String // Education
        ) {
            @JsonClass(generateAdapter = true)
            data class Data(
                @Json(name = "achievements")
                val achievements: List<Achievement>,
                @Json(name = "degree")
                val degree: String,
                @Json(name = "institution")
                val institution: String,
                @Json(name = "period")
                val period: String
            ) {
                @JsonClass(generateAdapter = true)
                class Achievement
            }
        }

        @JsonClass(generateAdapter = true)
        data class Experience(
            @Json(name = "title")
            val title: String // Experience
        )

        @JsonClass(generateAdapter = true)
        data class FunFacts(
            @Json(name = "title")
            val title: String // Fun Facts
        )
    }
}