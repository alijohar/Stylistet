package com.amorphteam.stylistet.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.databinding.ItemDetailBinding
import com.amorphteam.stylistet.model.ItemCollection

class ItemsDetailAdapter(private val context: Context):
    ListAdapter<ItemCollection, ItemsDetailAdapter.ViewHolder>(ItemsDetailDiffCallback())  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)


    }



    class ViewHolder private constructor(val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ItemCollection
        ) {
            binding.title.text = item.title
            binding.price.text = item.price
            binding.storeName.text = item.storeName
            binding.image.setImageResource(item.image)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemDetailBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }




}

class ItemsDetailDiffCallback: DiffUtil.ItemCallback<ItemCollection>(){
    override fun areItemsTheSame(oldItem: ItemCollection, newItem: ItemCollection): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemCollection, newItem: ItemCollection): Boolean {
        return oldItem == newItem
    }

}
