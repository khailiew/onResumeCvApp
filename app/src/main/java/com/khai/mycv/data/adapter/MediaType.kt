package com.khai.mycv.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

enum class MediaType(val typeName: String) {
    TEXT ("text"),
    VIDEO_LINK ("video_link"),
    IMAGE ("image");

    companion object {
        fun fromString(type: String): MediaType? = values().associateBy(MediaType::typeName)[type]
    }
}

class MediaTypeAdapter: BaseTypeAdapter<MediaType>() {
    @ToJson
    override fun toJson(type:MediaType): String = type.typeName

    @FromJson
    override fun fromJson(value: String): MediaType? = MediaType.fromString(value)

}