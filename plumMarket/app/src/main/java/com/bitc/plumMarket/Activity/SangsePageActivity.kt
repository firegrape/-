package com.bitc.plumMarket.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.RetrofitBuilder
import com.bitc.plumMarket.databinding.ActivitySangsePageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SangsePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySangsePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idx = intent.getStringExtra("selected_idx").toString()
        Log.d("idx",idx)


        RetrofitBuilder.api.getListData(idx).enqueue(object : Callback<ListData> {
            override fun onResponse(call: Call<ListData>, response: Response<ListData>) {
                if (response.isSuccessful) {
                    val title = response.body()?.list_title.toString()
                    val content = response.body()?.list_content.toString()
                    val money = response.body()?.list_money.toString()
                    val nick = response.body()?.list_user_nick.toString()

                    binding.TvTitle.text = title
                    binding.tvcontent.text = content
                    binding.tvMoney.text = money
                    Log.d("money",money)
                    binding.tvUserId.text = nick
                } else {
                    Log.d("ysh", "Server response unsuccessful. Code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ListData>, t: Throwable) {
                Log.e("error", "Network request failed", t)
            }
        })


        binding.btnBack.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.btnHome.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.btnChatting.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // 점점점 아이콘 이동 경로 미정
        binding.jumjumjum.setOnClickListener {
            intent = Intent(this, GesigeulPageActivity::class.java)
            startActivity(intent)
        }
    }
}