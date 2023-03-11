package com.amorphteam.stylistet.launcher.launcher

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentLauncherBinding
import com.amorphteam.stylistet.launcher.customize.SeekBarModel
import java.time.chrono.JapaneseEra.values
import kotlin.random.Random

class LauncherFragment : Fragment() {

    companion object {
        fun newInstance() = LauncherFragment()
    }

    private lateinit var binding: FragmentLauncherBinding
    private lateinit var viewModel: LauncherViewModel
    private  var  myLauncherView: LauncherView = LauncherView()

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

        binding.launcherView = myLauncherView

        binding.launcherStartNow.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)
        }
        myLauncherView.onValueChanged()

        return binding.root

    }

}

