package com.amorphteam.stylistet.ui.recomanded

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentRecommendedBinding
import com.amorphteam.stylistet.model.CollectionModel
import com.amorphteam.stylistet.ui.adapter.StyleRecommendedAdapter
import com.amorphteam.stylistet.util.LocalData

class RecommendedFragment : Fragment() {

    private var _binding: FragmentRecommendedBinding? = null
    private lateinit var viewModel: RecommendedViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this).get(RecommendedViewModel::class.java)

        _binding = FragmentRecommendedBinding.inflate(inflater, container, false)

        val styleRecommendedAdapter = StyleRecommendedAdapter(requireContext())

        viewModel.result.observe(viewLifecycleOwner){
            handleRecyclerView(styleRecommendedAdapter, it)
        }

        return binding.root
    }

    private fun handleRecyclerView(
        styleRecommendedAdapter: StyleRecommendedAdapter,
        it: List<CollectionModel>?
    ) {
        styleRecommendedAdapter.submitList(it)
        val dimen_count = resources.getInteger(R.integer.columns_count)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(dimen_count, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter = styleRecommendedAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}