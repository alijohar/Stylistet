package com.amorphteam.stylistet.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.model.ItemCollection

class ItemsDetailAdapter(private val context: Context, private val items: ArrayList<ItemCollection>):
    RecyclerView.Adapter<ItemsDetailAdapter.ViewHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.price.text = items[position].price
        holder.storeName.text = items[position].storeName
        holder.image.setImageResource(items[position].image)

        holder.image.setOnClickListener {
            Toast.makeText(context, "I WIll OPEN THIS LINK LATER :) ", Toast.LENGTH_LONG).show()
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val price = itemView.findViewById<TextView>(R.id.price)
        val storeName = itemView.findViewById<TextView>(R.id.store_name)
        val image = itemView.findViewById<ImageView>(R.id.image)

    }



}