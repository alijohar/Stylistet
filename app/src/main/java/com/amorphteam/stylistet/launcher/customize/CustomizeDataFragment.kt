package com.amorphteam.stylistet.launcher.customize

import android.graphics.Rect
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.FragmentCustomizeDataBinding

class CustomizeDataFragment : Fragment() {

    companion object {
        fun newInstance() = CustomizeDataFragment()
    }
    private lateinit var binding: FragmentCustomizeDataBinding
    private lateinit var viewModel: CustomizeDataViewModel
    private  var  mySeekBarModel: SeekBarModel = SeekBarModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this)[CustomizeDataViewModel::class.java]

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_customize_data,container,false)
        binding.customizeDataViewModel = mySeekBarModel
        val adapter = FavotiteColorRecyclerAdapter(FavoriteColorListener {
                ColorId ->  Toast.makeText(context,"${ColorId}", Toast.LENGTH_SHORT).show()
        })

        binding.recyclerView.adapter = adapter
        adapter.submitList(ArrayList(viewModel.favoriteColor))


        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        return binding.root
    }


}