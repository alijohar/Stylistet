package com.amorphteam.stylistet.ui.recomanded

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecommendedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Recommended Fragment"
    }
    val text: LiveData<String> = _text
}