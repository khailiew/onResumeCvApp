package com.khai.mycv.data.common

import android.content.res.AssetManager

fun AssetManager.readJsonAsset(file: String): String =
    open(file).bufferedReader().use { it.readText() }
