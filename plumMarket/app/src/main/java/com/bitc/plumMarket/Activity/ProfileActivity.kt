package com.bitc.plumMarket.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bitc.plumMarket.MySharedpreferences
import com.bitc.plumMarket.databinding.ActivityProfileBinding
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fileName = MySharedpreferences.getFileUrl(this)

        binding.tvUserId.text = MySharedpreferences.getUserNick(applicationContext)


        val storage = FirebaseStorage.getInstance()
        val storageReference = storage.getReference("image")
        Log.d("image33",fileName)

        if (fileName.equals("null")) {
            Log.d("image", "데이터 없음")


        } else {
            val pathReference = storageReference.child(fileName)
            pathReference.downloadUrl.addOnSuccessListener { uri ->
                Glide.with(this).load(uri).into(binding.ivUser);
            }.addOnFailureListener {
                Log.d("image1", "가져오기 실패")
            }


        }
//       뒤로 가기 버튼
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }

//        평가 페이지 이동
        binding.btnPyeongga.setOnClickListener {
            val intent = Intent(this, PuynggaActivity::class.java)
            startActivity(intent)
        }

        // 프로필에서 판매로 넘어 가는 버튼
        binding.btnPanmea1.setOnClickListener {
            val intent = Intent(this, PanmaeActivity::class.java)
            startActivity(intent)
        }

        binding.btnGumae1.setOnClickListener {
            val intent = Intent(this, GumaeActivity::class.java)
            startActivity(intent)
        }

        binding.btnDeill.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        //       프로핗 수정 페이지
        binding.btnGallery.setOnClickListener {
            val intent = Intent(this, profilesojoungActivity::class.java)
            startActivity(intent)
        }

    }
}