package com.amorphteam.stylistet.util

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.model.*
import com.bumptech.glide.Glide

@BindingAdapter("itemStoreName")
fun TextView.itemStoreName(item: ItemSet?){
    item?.let {
        text = item.products[0].name
    }
}

@BindingAdapter("itemTitle")
fun TextView.itemTitle(item: ItemSet?){
    item?.let {
        text = item.products[0].name
    }
}


@BindingAdapter("itemPrice")
fun TextView.itemPrice(item: ItemSet?){
    item?.let {
        text = item.products[0].name
    }
}

@BindingAdapter("itemImage")
fun itemImage(image: ImageView, item: ItemSet?){
    Log.i("AJC", "http://82.115.19.138:8000"+item?.products!![0].main_image)
    Glide.with(image.context)
        .load("http://82.115.19.138:8000"+item?.products!![0].main_image)
        .into(image)
}

@BindingAdapter("recommendedTitle")
fun recommendedTitle(textView: TextView, item: CollectionModel?){
        textView.text = (item?.name)
}

@BindingAdapter("recommendedImage")
fun setImage(image: ImageView, item: CollectionModel?){
    Glide.with(image.context)
        .load(item?.main_image)
        .into(image)

}
