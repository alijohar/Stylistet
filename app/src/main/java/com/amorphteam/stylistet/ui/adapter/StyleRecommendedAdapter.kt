package com.amorphteam.stylistet.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.model.ImgeWithTag

class StyleRecommendedAdapter(private val context: Context, private val imageItems: ArrayList<ImgeWithTag>):
    RecyclerView.Adapter<StyleRecommendedAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_style_recommended, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = imageItems[position].tag
        holder.imageView.setImageResource(imageItems[position].image)
    }

    override fun getItemCount(): Int {
        return imageItems.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.item_name)
        val imageView = itemView.findViewById<ImageView>(R.id.item_image)
    }
}