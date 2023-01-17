package com.amorphteam.stylistet.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavItemsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is FavItems Fragment"
    }
    val text: LiveData<String> = _text
}