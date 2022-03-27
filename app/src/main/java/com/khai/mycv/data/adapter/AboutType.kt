package com.khai.mycv.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

enum class AboutType(val typeName: String) {
    ABOUT_ME("me"),
    ABOUT_APP("app"),
    CONTACT_DETAILS("contact");

    companion object {
        fun fromType(type: String) = values().associateBy(AboutType::typeName)[type]
    }
}

class AboutTypeAdapter {
    @ToJson
    fun toJson(type: AboutType): String = type.typeName

    @FromJson
    fun fromJson(value: String): AboutType? = AboutType.fromType(value)

}