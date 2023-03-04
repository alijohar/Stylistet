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
import java.time.chrono.JapaneseEra.values
import kotlin.random.Random

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

        binding.launcherStartNow.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)
        }

        val randomEnumWelcomeClass: Welcome = Welcome.randomDirection()
        changeUiLauncher(randomEnumWelcomeClass)

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LauncherViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun changeUiLauncher(page: Welcome) = when (page) {
        Welcome.ONE -> {
            binding.launcherTitle.setTextColor(Color.BLUE)
            binding.launcherTitleTwo.setTextColor(Color.BLUE)
            binding.launcherStartNow.setBackgroundColor(Color.BLACK)
            binding.launcherSignIn.setTextColor(Color.WHITE)
            binding.launcherYouHaveAnAccount.setTextColor(Color.WHITE)
            binding.launcherMainLayout.setBackgroundResource(R.drawable.launcher_one)

        }
        Welcome.TWO -> {
            binding.launcherTitle.setTextColor(Color.WHITE)
            binding.launcherTitleTwo.setTextColor(Color.WHITE)
            binding.launcherStartNow.setBackgroundColor(Color.RED)
            binding.launcherSignIn.setTextColor(Color.WHITE)
            binding.launcherYouHaveAnAccount.setTextColor(Color.WHITE)
            binding.launcherMainLayout.setBackgroundResource(R.drawable.launcher_two)

        }
        Welcome.THREE -> {
            binding.launcherTitle.setTextColor(Color.BLUE)
            binding.launcherTitleTwo.setTextColor(Color.BLUE)
            binding.launcherStartNow.setBackgroundColor(Color.GRAY)
            binding.launcherSignIn.setTextColor(Color.WHITE)
            binding.launcherYouHaveAnAccount.setTextColor(Color.WHITE)
            binding.launcherMainLayout.setBackgroundResource(R.drawable.launcher_three)

        }
    }


}

