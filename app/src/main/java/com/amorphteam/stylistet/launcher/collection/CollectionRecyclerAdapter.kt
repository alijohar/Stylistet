package com.amorphteam.stylistet.launcher.collection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.R

class CollectionRecyclerAdapter(val arrayCollection: ArrayList<CollectionData>): RecyclerView.Adapter<CollectionRecyclerAdapter.ViewHolder>() {



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.image_collection)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_collection_fragment, parent ,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setBackgroundResource(arrayCollection[position].image)
    }

    override fun getItemCount(): Int {
        return arrayCollection.size
    }
}