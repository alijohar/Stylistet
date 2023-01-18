package com.amorphteam.stylistet.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.model.ImgeWithTag
import com.amorphteam.stylistet.ui.detail.DetailActivity
import com.amorphteam.stylistet.util.LocalData

class StyleRecommendedAdapter(private val context: Context, private val imageItems: ArrayList<ImgeWithTag>):
    RecyclerView.Adapter<StyleRecommendedAdapter.ViewHolder>()  {
    var likedCollections = ArrayList<Int>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_style_recommended, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = imageItems[position].tag
        holder.imageView.setImageResource(imageItems[position].image)

        holder.imageView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(LocalData.PASS_DATA, imageItems[position])
            context.startActivity(intent)
        }

        holder.imageButton.setOnClickListener {
            if (likedCollections.contains(position)){
                likedCollections.remove(position)
                holder.imageButton.setImageResource(R.drawable.heart_outline_flat)
            }else{
                likedCollections.add(position)
                holder.imageButton.setImageResource(R.drawable.heart_flat)
            }
        }
    }

    override fun getItemCount(): Int {
        return imageItems.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.item_name)
        val imageView = itemView.findViewById<ImageView>(R.id.item_image)
        val imageButton = itemView.findViewById<ImageButton>(R.id.like)


    }



}