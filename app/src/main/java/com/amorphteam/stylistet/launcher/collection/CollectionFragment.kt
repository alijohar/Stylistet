package com.amorphteam.stylistet.launcher.collection

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment() {

    private lateinit var binding: FragmentCollectionBinding
    private lateinit var viewModel: CollectionViewModel
    private var tracker: SelectionTracker<Long>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[CollectionViewModel::class.java]

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_collection, container, false)

        binding.next.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_collectionFragment_to_customizeDataFragment)

        }

        val manager = GridLayoutManager(activity, 3)
        binding.recyclerView.layoutManager = manager

        val adapter = CollectionRecyclerAdapter()

        adapter.submitList(ArrayList(viewModel.collections))
        binding.recyclerView.adapter = adapter

        tracker = SelectionTracker.Builder<Long>(
            "mySelection",
            binding.recyclerView,
            StableIdKeyProvider(binding.recyclerView),
            MyItemDetailsLookup(binding.recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()


        adapter.tracker = tracker


        return binding.root
    }


}
