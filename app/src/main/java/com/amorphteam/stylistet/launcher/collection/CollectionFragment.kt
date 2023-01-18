package com.amorphteam.stylistet.launcher.collection

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment() {

    companion object {
        fun newInstance() = CollectionFragment()
    }
    private lateinit var binding:FragmentCollectionBinding
    private lateinit var viewModel: CollectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_collection,container,false)

        binding.next.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_collectionFragment_to_customizeDataFragment)

        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollectionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}