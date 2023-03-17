package com.amorphteam.stylistet.launcher.collection

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

//TODO SELECTION IS NOT WORKING

class CollectionRecyclerAdapter(val clickListener: CollectionListener) :
    ListAdapter<CollectionData, CollectionRecyclerAdapter.ViewHolder>(CollectionDiffCallback()) {

    var tracker: SelectionTracker<String>? = null

    init {
        setHasStableIds(true)
    }

    class ViewHolder private constructor(val binding: CardViewCollectionFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: CollectionData,
            isActivated: Boolean,
            clickListener: CollectionListener,
            tracker: SelectionTracker<String>?
        ) = with(itemView) {

            binding.cardViewCollection = item
            binding.clickListener = clickListener
            binding.imageCollection.isVisible = !isActivated
            tracker?.addObserver(
                object : SelectionTracker.SelectionObserver<String>() {
                    override fun onSelectionChanged() {
                        super.onSelectionChanged()
                        val items: Int? = tracker?.selection?.size()
                        binding.textCollection.isVisible = items!! > 0
                    }
                })

            binding.executePendingBindings()

        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<String> =
            object : ItemDetailsLookup.ItemDetails<String>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): String? = itemId.toString()


            }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    CardViewCollectionFragmentBinding.inflate(layoutInflater, parent, false)
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

        tracker?.let {
            p0.bind(item, it.isSelected(p1.toLong().toString()), clickListener, tracker)

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

class CollectionListener(val clicklistener: (collectionId: Int) -> Unit) {

    fun onClick(collection: CollectionData) = clicklistener(collection.id)

}

class MyItemKeyProvider(private val adapter: CollectionRecyclerAdapter) :
    ItemKeyProvider<String>(SCOPE_CACHED) {
    override fun getKey(position: Int): String? =
        adapter.currentList[position].name

    override fun getPosition(key: String): Int =
        adapter.currentList.indexOfFirst { it.name == key }
}

class MyItemDetailsLookup(private val recyclerView: RecyclerView) :
    ItemDetailsLookup<String>() {
    override fun getItemDetails(event: MotionEvent): ItemDetails<String>? {
        val view = recyclerView.findChildViewUnder(event.x, event.y)
        if (view != null) {
            return (recyclerView.getChildViewHolder(view) as CollectionRecyclerAdapter.ViewHolder).getItemDetails()
        }
        return null
    }
}
