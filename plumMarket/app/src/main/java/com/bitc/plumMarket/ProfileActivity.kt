package com.bitc.plumMarket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.plumMarket.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 프로필에서 판매로 넘어 가는 버튼
        binding.btnPan.setOnClickListener {
            intent = Intent(this, PanmaeActivity::class.java)
            startActivity(intent)
        }

//        뒤로 가기 버튼
        binding.btnBack.setOnClickListener {
            intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }

//        거래 후기 이동 버튼
    }
}