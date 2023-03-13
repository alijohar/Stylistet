package com.amorphteam.stylistet.launcher.customize

import android.graphics.Rect
import android.provider.Settings.Secure.getString
import android.widget.SeekBar
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.databinding.adapters.SeekBarBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amorphteam.stylistet.R
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider


class CustomizeDataViewModel : ViewModel() {

    private val _rangeSlider = MutableLiveData<RangeSlider>()
    val rangeSlider: LiveData<RangeSlider>
        get() = _rangeSlider



    val favoriteColor = listOf(
        FavoriteColorData(1, R.drawable.nature_color, "الطبيعة"),
        FavoriteColorData(2, R.drawable.pastel_color, "باستيلي"),
        FavoriteColorData(3, R.drawable.bright_color, "ساطعة"),
        FavoriteColorData(4, R.drawable.dark_color, "غامقة"),
        FavoriteColorData(5, R.drawable.metallic_color, "متاليك")
    )



    }



