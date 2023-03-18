package com.amorphteam.stylistet.launcher.collection

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amorphteam.stylistet.databinding.CardViewCollectionFragmentBinding

class CollectionRecyclerAdapter :
    ListAdapter<CollectionData, CollectionRecyclerAdapter.ViewHolder>(CollectionDiffCallback()) {

    var tracker: SelectionTracker<Long>? = null

    init {
        setHasStableIds(true)
    }

    inner class ViewHolder (val binding: CardViewCollectionFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: CollectionData,
            isActivated: Boolean,
        ) = with(itemView) {
            binding.cardViewCollection = item
            binding.executePendingBindings()
            binding.selectedBu.isVisible = isActivated
        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): Long = itemId
                override fun inSelectionHotspot(e: MotionEvent): Boolean = true

            }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding =
            CardViewCollectionFragmentBinding.inflate(layoutInflater, p0, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        //p0 = holder
        //p1 = position
        val item = getItem(p1)

        tracker?.let {
            p0.bind(item, it.isSelected(p1.toLong()))

        }

    }

    override fun getItemId(position: Int): Long = position.toLong()

}

class CollectionDiffCallback : DiffUtil.ItemCallback<CollectionData>() {
    override fun areItemsTheSame(p0: CollectionData, p1: CollectionData): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: CollectionData, p1: CollectionData): Boolean {
        return p0 == p1
    }
}



