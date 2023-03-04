package com.amorphteam.stylistet.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.amorphteam.stylistet.model.ImgeWithTag
import com.amorphteam.stylistet.model.ItemCollection

@BindingAdapter("itemStoreName")
fun TextView.itemStoreName(item: ItemCollection?){
    item?.let {
        text = item.storeName
    }
}

@BindingAdapter("itemTitle")
fun TextView.itemTitle(item: ItemCollection?){
    item?.let {
        text = item.title
    }
}


@BindingAdapter("itemPrice")
fun TextView.itemPrice(item: ItemCollection?){
    item?.let {
        text = item.price
    }
}

@BindingAdapter("itemImage")
fun ImageView.itemImage(item: ItemCollection?){
    item?.let {
        setImageResource(item.image)
    }
}

@BindingAdapter("recommendedTitle")
fun TextView.recommendedTitle(item: ImgeWithTag?){
    item?.let {
        text = (item.tag)
    }
}

@BindingAdapter("recommendedImage")
fun ImageView.recommendedImage(item: ImgeWithTag?){
    item?.let {
        setImageResource(item.image)
    }
}
