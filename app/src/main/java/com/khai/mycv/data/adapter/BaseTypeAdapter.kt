package com.khai.mycv.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

abstract class BaseTypeAdapter<T> {
    @ToJson
    abstract fun toJson(type: T): String

    @FromJson
    abstract fun fromJson(value: String): T?
}