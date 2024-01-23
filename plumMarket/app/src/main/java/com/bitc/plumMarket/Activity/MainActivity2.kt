package com.bitc.plumMarket.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.plumMarket.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //              알람 엑티비티 이동 버튼
        binding.btnAlream.setOnClickListener {
            val intent = Intent(this, AlleramActivity::class.java)
            startActivity(intent)
        }

        //           검색 페이지 이동 버튼
        binding.btnBogie.setOnClickListener {
            val intent = Intent(this, BogieActivity::class.java)
            startActivity(intent)
        }

        //           동내 위치로 이동 튼
        binding.btnMap.setOnClickListener {
            val intent = Intent(this, DongneaActivity::class.java)
            startActivity(intent)

        }
    }
}