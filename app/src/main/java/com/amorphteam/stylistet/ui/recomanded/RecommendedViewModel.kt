package com.amorphteam.stylistet.ui.recomanded

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amorphteam.stylistet.model.CollectionModel
import com.amorphteam.stylistet.util.ApiHelper
import com.amorphteam.stylistet.util.Connection.Companion.isInternetConnected
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecommendedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Recommended Fragment"
    }
    val text: LiveData<String> = _text
    var apiHelper = ApiHelper()

    val _results = MutableLiveData<List<CollectionModel>>()
    val result:LiveData<List<CollectionModel>>
        get() = _results

    init {
        getOnlineModel()
    }

    private fun getOnlineModel() {
        apiHelper?.getCollection(_results)
    }
}