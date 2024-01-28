package com.bitc.plumMarket.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bitc.plumMarket.Adapter.SlideAdapter
import com.bitc.plumMarket.Adapter.imageAdapter
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
        var idx= intent.getIntExtra("selected_idx", -1).toString()









        val imageUriList = mutableListOf<String>()
     Log.d("tyttt", "${imageUriList}")
//    뷰 페이저2에 사용할 프래그먼트 리스트 생성


        //    뷰 페이저2 어뎁터에 사용할 프래그먼트 리스트 등록


        RetrofitBuilder.api.DetailSelect(idx).enqueue(object : Callback<List<ListData>> {
            override fun onResponse(call: Call<List<ListData>>, response: Response<List<ListData>>) {
                if (response.isSuccessful) {
                    val list = response.body()
                    val items = mutableListOf<ListData>()

                    if (list != null) {
                        // listData를 활용하여 필요한 처리를 수행해주세요
                        // 예시: listData를 순회하며 각 객체의 필드를 읽어옴
                        for (data in list) {
                            val idx = data.list_idx
                            val title = data.list_title
                            val money = data.list_money
                            val loc = data.list_loc
                            val content = data.list_content
                            val nick = data.list_user_nick
                            val image = data.list_image_name

                            binding.TvTitle.text = title.toString()
                            binding.tvcontent.text = content.toString()
                            binding.tvMoney.text = money.toString()
                            binding.tvUserId.text = nick.toString()

                            // 이미지 변수를 imageUriList에 추가
                            imageUriList.add(image)
                        }

                        // 이미지 추가 후 뷰페이저 어댑터에 전달
                        val viewPager = binding.viewPagerSlide
                        viewPager.adapter = SlideAdapter(this@SangsePageActivity, imageUriList)
                        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                    } else {
                        Log.d("ysh", "listData is null")
                    }
                } else {
                    Log.d("ysh", "Server response unsuccessful. Code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ListData>>, t: Throwable) {
                Log.e("error", "Network request failed", t)
            }
        })


        val viewPager = binding.viewPagerSlide
        viewPager.adapter = SlideAdapter(this, imageUriList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL




        binding.btnBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnHome.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnChatting.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 점점점 아이콘 이동 경로 미정
        binding.jumjumjum.setOnClickListener {
            intent = Intent(this, GesigeulPageActivity::class.java)
            startActivity(intent)
        }
    }
}