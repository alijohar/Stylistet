package com.amorphteam.stylistet.ui.adapter

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.databinding.ItemDetailBinding
import com.amorphteam.stylistet.model.ItemSet

class ItemsDetailAdapter(private val context: Context):
    ListAdapter<ItemSet, ItemsDetailAdapter.ViewHolder>(ItemsDetailDiffCallback())  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)


    }



    class ViewHolder private constructor(private val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ItemSet
        ) {
            binding.item = item
            binding.executePendingBindings()
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

class ItemsDetailDiffCallback: DiffUtil.ItemCallback<ItemSet>(){
    override fun areItemsTheSame(oldItem: ItemSet, newItem: ItemSet): Boolean {
        return oldItem.pk == newItem.pk
    }

    override fun areContentsTheSame(oldItem: ItemSet, newItem: ItemSet): Boolean {
        return oldItem == newItem
    }

}
