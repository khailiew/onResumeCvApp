package com.khai.mycv.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

enum class AboutType(val typeName: String) {
    ABOUT_ME("about_me"),
    ABOUT_APP("about_app"),
    CONTACT_DETAILS("contact");

    companion object {
        fun fromString(type: String): AboutType? = values().associateBy(AboutType::typeName)[type]
    }
}

class AboutTypeAdapter: BaseTypeAdapter<AboutType>() {
    @ToJson
    override fun toJson(type: AboutType): String = type.typeName

    @FromJson
    override fun fromJson(value: String): AboutType? = AboutType.fromString(value)

}