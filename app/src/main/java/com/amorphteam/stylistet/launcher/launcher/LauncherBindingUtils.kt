package com.amorphteam.stylistet.launcher.launcher

import android.content.ClipData.Item
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.amorphteam.stylistet.launcher.customize.FavoriteColorData


@BindingAdapter("android:textColor")
fun setTextColor(view: TextView, color: Int?) {
    view.setTextColor(color!!)

}

@BindingAdapter("android:background")
    fun setBackgroundResource(view: LinearLayout, back: Int?){
        view.setBackgroundResource(back!!)
}

