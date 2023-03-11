package com.amorphteam.stylistet.launcher.customize

import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.SeekBarBindingAdapter.OnProgressChanged


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
@BindingAdapter("android:onProgressChanged")
fun setListener(view: SeekBar?, listener: OnProgressChanged?) {
    setListener(view!!,  listener!!)
}



