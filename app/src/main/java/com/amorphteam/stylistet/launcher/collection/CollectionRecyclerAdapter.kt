package com.amorphteam.stylistet.launcher.collection

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.databinding.CardViewCollectionFragmentBinding

class CollectionRecyclerAdapter(): ListAdapter<CollectionData, CollectionRecyclerAdapter.ViewHolder>(CollectionDiffCallback()){

    class ViewHolder private constructor(val binding: CardViewCollectionFragmentBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: CollectionData) {
            binding.cardViewCollection = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardViewCollectionFragmentBinding.inflate(layoutInflater, parent,false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        //p0 = parent
        //p1 = view type
        return ViewHolder.from(p0)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        //p0 = holder
        //p1 = position
        val item = getItem(p1)
        p0.bind(item)
    }

}

class CollectionDiffCallback : DiffUtil.ItemCallback<CollectionData>() {
    override fun areItemsTheSame(p0: CollectionData, p1: CollectionData): Boolean {
        return p0.image == p1.image
    }

    override fun areContentsTheSame(p0: CollectionData, p1: CollectionData): Boolean {
        return p0 == p1
    }
}