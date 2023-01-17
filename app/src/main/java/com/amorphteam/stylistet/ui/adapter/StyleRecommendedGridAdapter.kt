package com.amorphteam.stylistet.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.model.ImgeWithTag
import com.bumptech.glide.Glide

class StyleRecommendedGridAdapter(private val context: Context, private val imageItems: ArrayList<ImgeWithTag>) :
    BaseAdapter() {
    var inflater: LayoutInflater? = null
    override fun getCount(): Int {
        return imageItems.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        this.inflater = LayoutInflater.from(context);
        var view = convertView
        if (view == null) {
            view = inflater?.inflate(R.layout.item_style_recommended, null);
        }
        val textView = view?.findViewById<TextView>(R.id.item_name)
        val imageView = view?.findViewById<ImageView>(R.id.grid_image)

        textView?.text = imageItems[position].tag
        Glide.with(context).load(imageItems[position].image).into(imageView!!)
        return view
    }

}