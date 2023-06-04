package com.amorphteam.stylistet.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.ActivityDetailBinding
import com.amorphteam.stylistet.model.CollectionModel
import com.amorphteam.stylistet.model.ImgeWithTag
import com.amorphteam.stylistet.ui.adapter.ItemsDetailAdapter
import com.amorphteam.stylistet.util.LocalData

class DetailActivity : AppCompatActivity() {
    lateinit var item: CollectionModel
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getSerializableExtra(LocalData.PASS_DATA) as CollectionModel
        hideStatusBar()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.viewModel = viewModel
        binding.item = item
        viewModel.getOnlineModel(item.pk)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        binding.toolbarLayout.title = item.name


        viewModel.result.observe(this){
            val itemsDetailAdapter = ItemsDetailAdapter(this)
            itemsDetailAdapter.submitList(it)
            binding.content.recyclerView.setHasFixedSize(false)
            binding.content.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.content.recyclerView.adapter = itemsDetailAdapter
        }



    }

    private fun hideStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.like -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}