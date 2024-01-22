package com.bitc.plumMarket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.plumMarket.databinding.ActivityGansimBinding

class GansimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGansimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }
    }
}