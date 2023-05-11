package com.amorphteam.stylistet.api

import com.amorphteam.stylistet.model.ImgeWithTag
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RequestApi {
    @GET("most_read.json")
    fun getList(): Deferred<List<ImgeWithTag>>


}