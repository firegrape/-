package com.bitc.plumMarket.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.bitc.plumMarket.Adapter.ViewPager2Adapter
import com.bitc.plumMarket.Fragment.OnSellCompleteListener
import com.bitc.plumMarket.Fragment.SellCompleteFragment
import com.bitc.plumMarket.Fragment.SellOngoingFragment

import com.bitc.plumMarket.Fragment.SellHideFragment
import com.bitc.plumMarket.R
import com.bitc.plumMarket.databinding.ActivityPanmaeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PanmaeActivity : AppCompatActivity(), OnSellCompleteListener {

    private lateinit var binding: ActivityPanmaeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPanmaeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }

    private fun initViewPager() {
        // ViewPager2 Adapter 셋팅
        val viewPager2Adapter = ViewPager2Adapter(this)
        viewPager2Adapter.addFragment(SellOngoingFragment())
        viewPager2Adapter.addFragment(SellCompleteFragment())
        viewPager2Adapter.addFragment(SellHideFragment())

        //Adapter 연결
        binding.ReviewPager2.apply {
            adapter = viewPager2Adapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        // ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tlNavigationView, binding.ReviewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "판매중"
                1 -> tab.text = "거래완료"
                2 -> tab.text = "숨김"
            }
        }.attach()


        // 뒤로가기 버튼 사용 마이페이지 이동
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MypageActivity::class.java))
        }

        // 글쓰기 버튼 클릭 페이지 이전
        binding.writeButton.setOnClickListener {
            startActivity(Intent(this, WriteActivity::class.java))
        }
    }

    override fun onSellComplete() {
        TODO("Not yet implemented")
    }
}