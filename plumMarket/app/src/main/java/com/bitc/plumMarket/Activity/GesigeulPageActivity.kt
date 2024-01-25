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
        super.onCreate(savedInstanceState)
        val binding = ActivityGesigeulPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent에서 'idx_from_bottom_sheet' 키로 전달된 값 읽어오기
        val receivedIdx = intent.getStringExtra("idx_from_bottom_sheet")

        // 값이 null이 아닌지 확인 후 사용
        if (receivedIdx != null) {
            // 'receivedIdx' 값을 필요한 대로 사용
            Log.d("GesigeulPageActivity", "받은 idx: $receivedIdx")

            // 'receivedIdx'를 사용하여 데이터를 등록할 수 있는 부분
            binding.btnSujoungWan.setOnClickListener {
                val title = binding.edTitle.text.toString()
                val money = binding.edMoney.text.toString()
                val content = binding.edcontent.text.toString()
                val loc = "부산진구"


                // Retrofit을 사용하여 서버에 데이터를 등록
                RetrofitBuilder.api.UpdateList(title, money, content, receivedIdx, loc)
                    .enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@GesigeulPageActivity,
                                    "수정되었습니다.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish() // Optional: Close this activity after successful update
                            } else {
                                Log.d("ysh", "listData is null")
                            }
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            Log.d("error", t.localizedMessage)
                        }
                    })

                val intent = Intent(this, SangsePageActivity::class.java)
                startActivity(intent)
            }



            // 'btnBack', 'btnHome', 'btnSujoungWan' 버튼의 클릭 리스너 등록
            binding.btnBack.setOnClickListener {
                val intent = Intent(this, SangsePageActivity::class.java)
                startActivity(intent)
            }

            binding.btnHome.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

        } else {
            Log.d("GesigeulPageActivity", "받은 idx가 없습니다.")
            // idx가 없으면 필요한 처리를 여기에 추가
            // 예: 사용자에게 알림을 표시하거나, 다른 화면으로 이동
        }
    }
}