package com.dylanturney.buzzmove.util

import android.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

object BindingUtil {

    @BindingAdapter("fresco:actualImageUri")
    @JvmStatic
    fun loadImage(view: SimpleDraweeView, imageUrl: String?) {
        view.setImageURI(imageUrl)
    }

}