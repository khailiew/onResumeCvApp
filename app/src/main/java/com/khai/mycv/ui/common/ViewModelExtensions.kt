package com.khai.mycv.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// ref: https://stackoverflow.com/questions/69150992/how-can-i-create-common-viewmodelfactory-with-repository-in-kotlin-android
fun <T : ViewModel> T.createFactory(): ViewModelProvider.Factory {
    val viewModel = this
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModel as T
    }
}