package com.amorphteam.stylistet.model

data class ItemSet(
    val item_url: String,
    val name: String,
    val pk: Int,
    val products: List<Product>
)