package com.amorphteam.stylistet.launcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amorphteam.stylistet.R
import com.amorphteam.stylistet.databinding.ActivityLauncherBinding
import com.amorphteam.stylistet.databinding.ActivityMainBinding

class LauncherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}