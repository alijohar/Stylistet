package com.amorphteam.stylistet.model

data class CollectionItemModel(
    val created_at: String,
    val description: String,
    val id: Int,
    val item_set: List<ItemSet>,
    val main_image: String,
    val name: String,
    val slug: String,
    val updated_at: String
)