package com.amorphteam.stylistet.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.ActivityDetailBinding
import com.amorphteam.stylistet.model.ImgeWithTag
import com.amorphteam.stylistet.ui.adapter.ItemsDetailAdapter
import com.amorphteam.stylistet.ui.adapter.StyleRecommendedAdapter
import com.amorphteam.stylistet.util.LocalData

class DetailActivity : AppCompatActivity() {
    lateinit var item: ImgeWithTag
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getSerializableExtra(LocalData.PASS_DATA) as ImgeWithTag
        hideStatusBar()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        binding.mainImage.setImageResource(item.image)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        binding.toolbarLayout.title = title

        val itemsDetailAdapter = ItemsDetailAdapter(this, LocalData.getItemsData())
        binding.content.recyclerView.setHasFixedSize(false)
        binding.content.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.content.recyclerView.adapter = itemsDetailAdapter


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