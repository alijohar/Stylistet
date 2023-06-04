package com.amorphteam.stylistet.util

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.amorphteam.stylistet.model.CollectionModel
import com.amorphteam.stylistet.model.ItemSet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ApiHelper {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

        fun getCollection(array: MutableLiveData<List<CollectionModel>>) {
            Log.i("AJC", "Ohhh you come here")
            val deferredList = com.amorphteam.stylistet.api.Collection.retrofitService.getCollection()

            uiScope.launch {
                try {
                    val listResult = deferredList.await()
                    array.value = listResult
                }catch (e:java.lang.Exception){
                    Log.i("AJC", e.message.toString())
                }
            }
        }


    fun getCollectionItems(id:Int, array: MutableLiveData<List<ItemSet>>) {
        Log.i("AJC", id.toString())
        val deferredList = com.amorphteam.stylistet.api.Collection.retrofitService.getCollectionItems(
            id.toString()
        )

        uiScope.launch {
            try {
                val listResult = deferredList.await()
                array.value = listResult.item_set
            }catch (e:java.lang.Exception){
                Log.i("AJC", e.message.toString())
            }
        }
    }
}