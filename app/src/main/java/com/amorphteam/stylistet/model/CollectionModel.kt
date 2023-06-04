package com.amorphteam.stylistet.model

import java.io.Serializable

data class CollectionModel(
    val collection_url: String,
    val main_image: String,
    val name: String,
    val pk: Int
): Serializable