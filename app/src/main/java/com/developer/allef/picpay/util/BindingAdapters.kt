package com.developer.allef.picpay.util

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.developer.allef.picpay.R
import com.developer.allef.picpay.extensions.loadImgCircle

/**
 * @author allef.santos on 02/08/20
 */
class BindingAdapters {

    companion object {

//        @BindingAdapter("items")
//        @JvmStatic
//        fun setItems(recyclerView: RecyclerView, list: List<*>) {
//            recyclerView.adapter.let {
//                if (it is AdapterItemsContract) {
//                    it.replaceItems(list)
//                }
//            }
//        }

        @BindingAdapter("imageCircleUrl")
        @JvmStatic
        fun setImage(img: ImageView, url: String) {
            Glide.with(img)
                .applyDefaultRequestOptions(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .applyDefaultRequestOptions(RequestOptions().circleCrop())
                .load(url)
                .into(img)
        }

        @BindingAdapter("maskField")
        @JvmStatic
        fun setMask(editText: EditText, mask: String) {
            editText.addMask(mask)
        }

        @BindingAdapter("colorTextController")
        @JvmStatic
        fun setColorText(view: TextView, flag: Boolean) {
            if (flag) {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.enableForm))
            } else {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.disableFrom))
            }
        }

        @BindingAdapter("backgroundButtonController")
        @JvmStatic
        fun setBackgroundButton(button: Button, flag: Boolean) {
            button.isEnabled = flag
        }

    }

}