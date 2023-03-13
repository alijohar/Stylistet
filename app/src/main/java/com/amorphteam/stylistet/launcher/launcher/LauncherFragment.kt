package com.amorphteam.stylistet.launcher.launcher

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentLauncherBinding
import com.amorphteam.stylistet.launcher.customize.CustomizeDataViewModel

class LauncherFragment : Fragment() {

    private lateinit var binding: FragmentLauncherBinding
    private lateinit var viewModel: LauncherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_launcher,
            container,
            false
        )


        viewModel = ViewModelProvider(this)[LauncherViewModel::class.java]

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_launcher, container, false)
        binding.viewModel = viewModel

        viewModel.onValueChanged()

        binding.launcherStartNow.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)
        }

        return binding.root

    }

}

