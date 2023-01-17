package com.amorphteam.stylistet.ui.recomanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.amorphteam.stylistet.databinding.FragmentRecommendedBinding
import com.amorphteam.stylistet.ui.adapter.StyleRecommendedGridAdapter
import com.amorphteam.stylistet.util.LocalData

class RecommendedFragment : Fragment() {

    private var _binding: FragmentRecommendedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val recommendedViewModel =
            ViewModelProvider(this).get(RecommendedViewModel::class.java)

        _binding = FragmentRecommendedBinding.inflate(inflater, container, false)

        val gridAdapter = StyleRecommendedGridAdapter(requireContext(), LocalData.getData())
        binding.gridView.adapter = gridAdapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}