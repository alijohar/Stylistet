package com.amorphteam.stylistet.util

import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.model.ImgeWithTag
import com.amorphteam.stylistet.model.ItemCollection

class LocalData {

    companion object {
        val PASS_DATA = "PASS_DATA"

        fun getLikeItemsData():ArrayList<ItemCollection> {
            val items = ArrayList<ItemCollection>()
            items.add(ItemCollection(0, R.drawable.item1, "Elastic Waist Pleated Palazzo Trousers", "125 $", "Namshi Emirates store"))
            items.add(ItemCollection(0, R.drawable.item2, "Pleated Palazzo Trousers Tap", "15 $", "Namshi Emirates store"))
            items.add(ItemCollection(0, R.drawable.item3, "Trousers Shoes", "222 $", "Namshi Emirates store"))
            return items
        }

        fun getItemsData():ArrayList<ItemCollection> {
            val items = ArrayList<ItemCollection>()
            items.add(ItemCollection(0, R.drawable.item1, "Elastic Waist Pleated Palazzo Trousers", "125 $", "Namshi Emirates store"))
            items.add(ItemCollection(0, R.drawable.item2, "Pleated Palazzo Trousers Tap", "15 $", "Namshi Emirates store"))
            items.add(ItemCollection(0, R.drawable.item3, "Trousers Shoes", "222 $", "Namshi Emirates store"))
            return items
        }
        fun getData(): ArrayList<ImgeWithTag> {
            val styleImages = ArrayList<ImgeWithTag>()
            styleImages.add(ImgeWithTag(R.drawable.new4, "street"))
            styleImages.add(ImgeWithTag(R.drawable.new6, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.new2, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.new3, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.new5, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.new7, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.new1, "street"))
            styleImages.add(ImgeWithTag(R.drawable.new8, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a1, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a42, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a2, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a5, "street"))
            styleImages.add(ImgeWithTag(R.drawable.a8, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a44, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a19, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a22, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a3, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a6, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a7, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a9, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a4, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a24, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a25, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a26, "street"))
            styleImages.add(ImgeWithTag(R.drawable.a27, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a28, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a36, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a29, "street"))
            styleImages.add(ImgeWithTag(R.drawable.a30, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a31, "street"))
            styleImages.add(ImgeWithTag(R.drawable.a32, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a33, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a20, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a34, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a35, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a57, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a50, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a37, "street"))
            styleImages.add(ImgeWithTag(R.drawable.a39, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a41, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a47, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a63, "street"))
            styleImages.add(ImgeWithTag(R.drawable.a48, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a38, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a49, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a18, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a60, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a51, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a52, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a46, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a10, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a11, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a12, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a14, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a15, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a16, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a13, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a17, "minimal"))
            styleImages.add(ImgeWithTag(R.drawable.a21, "maximal"))
            styleImages.add(ImgeWithTag(R.drawable.a23, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a53, "boho"))
            styleImages.add(ImgeWithTag(R.drawable.a54, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a45, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a55, "vintage"))
            styleImages.add(ImgeWithTag(R.drawable.a56, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a59, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a43, "tomboy"))
            styleImages.add(ImgeWithTag(R.drawable.a58, "elegant"))
            styleImages.add(ImgeWithTag(R.drawable.a61, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a64, "street"))
            styleImages.add(ImgeWithTag(R.drawable.a62, "formal"))
            styleImages.add(ImgeWithTag(R.drawable.a65, "street"))

            return styleImages
        }

    }
}
