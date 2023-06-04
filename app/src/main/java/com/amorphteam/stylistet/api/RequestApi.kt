package com.amorphteam.stylistet.api

import com.amorphteam.stylistet.model.CollectionItemModel
import com.amorphteam.stylistet.model.CollectionModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestApi {
    @GET("collection/list?format=json")
    fun getCollection(): Deferred<List<CollectionModel>>

    @GET("collection/{id}/?format=json")
    fun getCollectionItems(@Path("id") id: String): Deferred<CollectionItemModel>

}