package com.amorphteam.stylistet.launcher.customize

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.databinding.CardViewCustomizeFragmentBinding

class FavotiteColorRecyclerAdapter(): ListAdapter<FavoriteColorData,FavotiteColorRecyclerAdapter.ViewHolder>(CustomizeDiffCallback()) {

    class ViewHolder private constructor(val binding: CardViewCustomizeFragmentBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item: FavoriteColorData) {
            binding.cardViewCustomize = item
            binding.executePendingBindings()
        }

        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = CardViewCustomizeFragmentBinding.inflate(layoutInflater, parent, false)
                 return ViewHolder(binding)

             }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class CustomizeDiffCallback(): DiffUtil.ItemCallback<FavoriteColorData>(){
    override fun areItemsTheSame(p0: FavoriteColorData, p1: FavoriteColorData): Boolean {
        return p0.name == p1.name
    }

    override fun areContentsTheSame(p0: FavoriteColorData, p1: FavoriteColorData): Boolean {
        return p0 == p1
    }
}
