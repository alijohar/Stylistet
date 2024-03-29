package com.amorphteam.stylistet.launcher.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.next.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_collectionFragment)
        }

        return binding.root
    }

}