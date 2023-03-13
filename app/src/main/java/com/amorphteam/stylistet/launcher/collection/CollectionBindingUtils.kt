package com.amorphteam.stylistet.launcher.collection

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("imageCollection")
fun ImageView.setImageCollection(item: CollectionData?) {
    item?.let {
        setBackgroundResource(item.image)
    }

}


@BindingAdapter("nameCollection")
fun TextView.setNameCollection(item: CollectionData?) {
    item?.let {
        text = item.name
    }
}

