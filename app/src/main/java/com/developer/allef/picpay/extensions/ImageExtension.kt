package com.developer.allef.picpay.extensions

import android.content.Context
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

/**
 * @author allef.santos on 01/08/20
 */

@Throws(GlideException::class)
fun ImageView.loadImgCircle(imgUrl: String) {

    Glide.with(this)
        .applyDefaultRequestOptions(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
        .applyDefaultRequestOptions(RequestOptions().circleCrop())
        .load(imgUrl)
        .into(this)
}