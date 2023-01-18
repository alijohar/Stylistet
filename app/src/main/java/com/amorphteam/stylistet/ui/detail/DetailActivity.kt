package com.amorphteam.stylistet.ui.detail

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.ActivityDetailBinding
import com.amorphteam.stylistet.model.ImgeWithTag
import com.amorphteam.stylistet.util.LocalData

class DetailActivity : AppCompatActivity() {
    lateinit var item: ImgeWithTag
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getSerializableExtra(LocalData.PASS_DATA) as ImgeWithTag

        binding = ActivityDetailBinding.inflate(layoutInflater)

        binding.mainImage.setImageResource(item.image)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title

    }
}