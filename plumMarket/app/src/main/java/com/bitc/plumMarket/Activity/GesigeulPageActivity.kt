package com.bitc.plumMarket.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bitc.plumMarket.R
import com.bitc.plumMarket.RetrofitBuilder
import com.bitc.plumMarket.databinding.ActivityGesigeulPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GesigeulPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityGesigeulPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //           데이터를 등록 가능하게 만들수 있는 코드 작성 부분
        binding.btnSujoungWan.setOnClickListener {
            val title = binding.edTitle.text.toString()
            val money = binding.edMoney.text.toString()
            val content = binding.edcontent.text.toString()
            val idx = binding.edcontent.text.toString()



            RetrofitBuilder.api.writeListData(title, money,content,idx).enqueue(object : Callback<Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@GesigeulPageActivity, "수정되었습니다.", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Log.d("ysh", "listData is null")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })


            binding.btnBack.setOnClickListener {
                intent = Intent(this, SangsePageActivity::class.java)
                startActivity(intent)
            }


            binding.btnHome.setOnClickListener {
                intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

            binding.btnSujoungWan.setOnClickListener {
                intent = Intent(this, SangsePageActivity::class.java)
                startActivity(intent)
            }


        }
    }
}