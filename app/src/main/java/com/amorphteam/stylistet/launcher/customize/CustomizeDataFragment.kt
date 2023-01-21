package com.amorphteam.stylistet.launcher.customize

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentCollectionBinding
import com.amorphteam.stylistet.databinding.FragmentCustomizeDataBinding
import com.amorphteam.stylistet.launcher.collection.CollectionData
import com.amorphteam.stylistet.launcher.collection.CollectionRecyclerAdapter

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

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = FavotiteColorRecyclerAdapter(ArrayList(favoriteColor))
        }

        return binding.root
    }

    val favoriteColor = listOf(
        FavoriteColorData(R.drawable.nature_color,"الطبيعة"),
        FavoriteColorData(R.drawable.pastel_color,"باستيلي"),
        FavoriteColorData(R.drawable.bright_color,"ساطعة"),
        FavoriteColorData(R.drawable.dark_color,"غامقة"),
        FavoriteColorData(R.drawable.metallic_color,"متاليك")
        )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CustomizeDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}