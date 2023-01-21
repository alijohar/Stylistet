package com.amorphteam.stylistet.launcher.customize

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.R

class FavotiteColorRecyclerAdapter(private val arrayColor: ArrayList<FavoriteColorData>): RecyclerView.Adapter<FavotiteColorRecyclerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.image_customize_color)
        var name = itemView.findViewById<TextView>(R.id.color_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_customize_fragment,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setBackgroundResource(arrayColor[position].image)
        holder.name.text = arrayColor[position].name
    }

    override fun getItemCount(): Int {
       return arrayColor.size
    }
}