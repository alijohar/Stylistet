package com.amorphteam.stylistet.launcher.customize

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentCollectionBinding
import com.amorphteam.stylistet.databinding.FragmentCustomizeDataBinding

class CustomizeDataFragment : Fragment() {

    companion object {
        fun newInstance() = CustomizeDataFragment()
    }
    private lateinit var binding: FragmentCustomizeDataBinding
    private lateinit var viewModel: CustomizeDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_customize_data,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CustomizeDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}