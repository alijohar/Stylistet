package com.amorphteam.stylistet.launcher.customize

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amorphteam.stylistet.MainActivity
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentCustomizeDataBinding
import com.google.android.material.slider.RangeSlider
import java.lang.String.format
import kotlin.collections.ArrayList

class CustomizeDataFragment : Fragment() {

    private lateinit var binding: FragmentCustomizeDataBinding
    private lateinit var viewModel: CustomizeDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this)[CustomizeDataViewModel::class.java]

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_customize_data, container, false)
        binding.viewModel = viewModel

        val adapter = FavotiteColorRecyclerAdapter(FavoriteColorListener { ColorId ->
            Toast.makeText(context, "${ColorId}", Toast.LENGTH_SHORT).show()
        })

        binding.next.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(ArrayList(viewModel.favoriteColor))


        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }



        binding.rangeSliderView.addOnSliderTouchListener(object :
            RangeSlider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: RangeSlider) {

            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                // Responds to when slider's touch event is being stopped
            }
        })


        binding.rangeSliderView.addOnChangeListener { rangeSlider, value, fromUser ->

            val arrayValue = binding.rangeSliderView.values


            if (arrayValue.contains(0.0.toFloat()) && arrayValue.contains(10.0.toFloat())) {
                binding.trickleRateValue.text = "$99 _ $9"

            } else if (arrayValue.contains(0.0.toFloat()) && arrayValue.contains(20.0.toFloat())) {
                binding.trickleRateValue.text = "$999 _ $9"

            } else if (arrayValue.contains(0.0.toFloat()) && arrayValue.contains(30.0.toFloat())) {
                binding.trickleRateValue.text = "$9999 _ $9"

            } else if (arrayValue.contains(10.0.toFloat()) && arrayValue.contains(20.0.toFloat())) {
                binding.trickleRateValue.text = "$999 _ $99"

            } else if (arrayValue.contains(10.0.toFloat()) && arrayValue.contains(30.0.toFloat())) {
                binding.trickleRateValue.text = "$9999 _ $99"

            } else if (arrayValue.contains(20.0.toFloat()) && arrayValue.contains(30.0.toFloat())) {
                binding.trickleRateValue.text = "$9999 _ $99"

            } else if (arrayValue.contains(30.0.toFloat()) && arrayValue.contains(30.0.toFloat())) {
                binding.trickleRateValue.text = "$9999"

            } else if (arrayValue.contains(20.0.toFloat()) && arrayValue.contains(20.0.toFloat())) {
                binding.trickleRateValue.text = "$999"

            } else if (arrayValue.contains(10.0.toFloat()) && arrayValue.contains(10.0.toFloat())) {
                binding.trickleRateValue.text = "$99"

            } else if (arrayValue.contains(0.0.toFloat()) && arrayValue.contains(0.0.toFloat())) {
                binding.trickleRateValue.text = "$9"

            }

        }

        binding.rangeSliderView.setLabelFormatter { value: Float ->
            when (value) {
                0.0.toFloat() -> format("$")
                10.0.toFloat() -> format("$$")
                20.0.toFloat() -> format("$$$")
                30.0.toFloat() -> format("$$$$")
                else -> {
                    format("$")
                }
            }
        }

        return binding.root
    }


}