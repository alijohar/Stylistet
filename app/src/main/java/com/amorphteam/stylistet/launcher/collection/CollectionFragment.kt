package com.amorphteam.stylistet.launcher.collection

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment() {

    companion object {
        fun newInstance() = CollectionFragment()
    }
    private lateinit var binding: FragmentCollectionBinding
    private lateinit var viewModel: CollectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_collection,container,false)

        binding.next.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_collectionFragment_to_customizeDataFragment)

        }

        val manager = GridLayoutManager(activity, 3)
        binding.recyclerView.layoutManager = manager

        val adapter = CollectionRecyclerAdapter(CollectionListener {
            collectionId ->  Toast.makeText(context, "${collectionId}", Toast.LENGTH_SHORT).show()
        })

        binding.recyclerView.adapter = adapter
        adapter.submitList(ArrayList(collections))



        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollectionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
val collections = listOf(
    CollectionData(1,R.drawable.collection1,"sam1"),
    CollectionData(2,R.drawable.collection2,"sam2"),
    CollectionData(3,R.drawable.collection3,"sam3"),
    CollectionData(4,R.drawable.collection4,"sam4"),
    CollectionData(5,R.drawable.collection5,"sam5"),
    CollectionData(6,R.drawable.collection6,"sam6"),
    CollectionData(7,R.drawable.collection7,"sam7"),
    CollectionData(8,R.drawable.collection8,"sam8"),
    CollectionData(9,R.drawable.collection9,"sam9"),
    CollectionData(10,R.drawable.collection1,"sam10"),
    CollectionData(11,R.drawable.collection2,"sam11"),
    CollectionData(12,R.drawable.collection3,"sam12")
)