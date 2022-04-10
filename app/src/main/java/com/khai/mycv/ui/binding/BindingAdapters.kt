package com.khai.mycv.ui.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.khai.mycv.R

@BindingAdapter("android:versionText")
fun setVersionText(view: TextView, version: String) {
    view.text = view.resources.getString(R.string.app_version, version)
}

@BindingAdapter("android:imgUrl")
fun loadImage(imageView: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        // https://support.exclaimer.com/hc/en-gb/articles/360040813912-How-to-host-images-using-Google-Drive
        Glide.with(imageView.context).load(url).into(imageView)
    }
}
