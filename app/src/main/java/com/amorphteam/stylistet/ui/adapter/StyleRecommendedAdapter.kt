package com.amorphteam.stylistet.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.ItemStyleRecommendedBinding
import com.amorphteam.stylistet.model.CollectionModel
import com.amorphteam.stylistet.ui.detail.DetailActivity
import com.amorphteam.stylistet.util.LocalData

class StyleRecommendedAdapter(val context: Context) :
    ListAdapter<CollectionModel, StyleRecommendedAdapter.ViewHolder>(StyleRecommendedDiffCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, context)


    }


    class ViewHolder private constructor(private val binding: ItemStyleRecommendedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var likedCollections = ArrayList<Int>()

        fun bind(
            item: CollectionModel, context: Context
        ) {
            binding.recommendedItem = item
            binding.executePendingBindings()

            binding.itemImage.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(LocalData.PASS_DATA, item)
                context.startActivity(intent)
            }

            binding.like.setOnClickListener {
                if (likedCollections.contains(position)) {
                    likedCollections.remove(position)
                    binding.like.setImageResource(R.drawable.like_detail)
                } else {
                    likedCollections.add(position)
                    binding.like.setImageResource(R.drawable.heart_flat)

                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStyleRecommendedBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }


}

class StyleRecommendedDiffCallback : DiffUtil.ItemCallback<CollectionModel>() {
    override fun areItemsTheSame(oldItem: CollectionModel, newItem: CollectionModel): Boolean {
        return oldItem.main_image == newItem.main_image
    }

    override fun areContentsTheSame(oldItem: CollectionModel, newItem: CollectionModel): Boolean {
        return oldItem == newItem
    }

}