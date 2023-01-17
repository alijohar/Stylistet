package com.amorphteam.stylistet.launcher.launcher

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentLauncherBinding

class LauncherFragment : Fragment() {

    companion object {
        fun newInstance() = LauncherFragment()
    }

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

        binding.next.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)
        }

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LauncherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}