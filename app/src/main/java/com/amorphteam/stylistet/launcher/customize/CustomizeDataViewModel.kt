package com.amorphteam.stylistet.launcher.customize

import android.provider.Settings.Secure.getString
import android.widget.SeekBar
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.databinding.adapters.SeekBarBindingAdapter
import androidx.lifecycle.ViewModel
import com.amorphteam.stylistet.R


class CustomizeDataViewModel : ViewModel() {
    var seekBarValue = ObservableField("$")
    var trickleRateValue = ObservableField("$9")

    val favoriteColor = listOf(
        FavoriteColorData(1, R.drawable.nature_color,"الطبيعة"),
        FavoriteColorData(2, R.drawable.pastel_color,"باستيلي"),
        FavoriteColorData(3, R.drawable.bright_color,"ساطعة"),
        FavoriteColorData(4, R.drawable.dark_color,"غامقة"),
        FavoriteColorData(5, R.drawable.metallic_color,"متاليك")
    )
    fun onValueChanged(seekBar: SeekBar?, progresValue: Int, fromUser: Boolean) {

        when(progresValue){
            1 -> seekBarValue.set("$")
            2 -> seekBarValue.set("$$")
            3 -> seekBarValue.set("$$$")
            4 -> seekBarValue.set("$$$$")
        }
        when(progresValue){
            1 -> trickleRateValue.set("$9")
            2 -> trickleRateValue.set("$99 _ $9")
            3 -> trickleRateValue.set("$999 _ $9")
            4 -> trickleRateValue.set("$9999 _ $9")
        }

    }
}


