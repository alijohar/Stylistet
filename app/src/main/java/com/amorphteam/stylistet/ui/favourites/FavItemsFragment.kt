package com.amorphteam.stylistet.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amorphteam.stylistet.databinding.FragmentFavItemsBinding
import com.amorphteam.stylistet.ui.adapter.ItemsDetailAdapter
import com.amorphteam.stylistet.util.LocalData

class FavItemsFragment : Fragment() {

    private var _binding: FragmentFavItemsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val favItemsViewModel =
            ViewModelProvider(this).get(FavItemsViewModel::class.java)

        _binding = FragmentFavItemsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val itemsDetailAdapter = ItemsDetailAdapter(requireContext())
//        itemsDetailAdapter.submitList(LocalData.getLikeItemsData())
        binding.recyclerView.setHasFixedSize(false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = itemsDetailAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}