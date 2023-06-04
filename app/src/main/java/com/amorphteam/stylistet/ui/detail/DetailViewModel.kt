package com.amorphteam.stylistet.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amorphteam.stylistet.model.CollectionItemModel
import com.amorphteam.stylistet.model.CollectionModel
import com.amorphteam.stylistet.model.ItemSet
import com.amorphteam.stylistet.util.ApiHelper

class DetailViewModel: ViewModel() {
    var apiHelper = ApiHelper()

    val _results = MutableLiveData<List<ItemSet>>()
    val result: LiveData<List<ItemSet>>
        get() = _results



    fun getOnlineModel(id: Int) {
        apiHelper.getCollectionItems(id, _results)
    }
}