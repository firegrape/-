package com.bitc.plumMarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.plumMarket.databinding.ActivityGumaeBinding

class GumaeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGumaeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}