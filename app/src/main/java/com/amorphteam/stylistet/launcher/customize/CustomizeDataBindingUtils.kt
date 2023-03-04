package com.amorphteam.stylistet.launcher.customize

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("customizeImageColor")
fun ImageView.setCustomizeImageColor(item: FavoriteColorData?) {
    item?.let {
        setBackgroundResource(item.image)
    }
}

@BindingAdapter("customizeTextColor")
fun TextView.setCustomizeTextColor(item: FavoriteColorData?){
    item?.let {
        text = item.name
    }
}