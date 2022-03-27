package com.khai.mycv.ui.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.khai.mycv.R

@BindingAdapter("android:versionText")
fun setVersionText(view: TextView, version: String) {
    view.text = view.resources.getString(R.string.app_version, version)
}
