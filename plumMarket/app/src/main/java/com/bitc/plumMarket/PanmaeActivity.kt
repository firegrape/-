package com.bitc.plumMarket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bitc.plumMarket.R
import com.bitc.plumMarket.databinding.ActivityPanmaeBinding

class PanmaeActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityPanmaeBinding
   // private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPanmaeBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  viewPager = findViewById(R.id.baseLayout)
      //  val pagerAdapter = MyPagerAdapter(mutableListOf("Fragment 1", "Fragment 2", "Fragment 3"))
       // viewPager.adapter = pagerAdapter



//        --------플래그 먼트 이용 해 뷰 이전--------------------
        val fragmentManager: FragmentManager = supportFragmentManager
        var transaction: FragmentTransaction = fragmentManager.beginTransaction()

        val fragment1 = Fragment1()
        val fragment2 = Fragment2()
        val fragment3 = Fragment3() // 추가된 부분

        transaction.add(R.id.baseLayout, fragment2)
        transaction.commit()

        
//        판매 버튼 사용후 텍스트 뷰 전환
        binding.salesButton.setOnClickListener {
            transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.baseLayout, fragment1)
            transaction.setReorderingAllowed(true)
            transaction.addToBackStack("")
            transaction.commit()
        }
//      거래 완료 버튼 사용후 텍스트 뷰 전환
        binding.completedButton.setOnClickListener {
            transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.baseLayout, fragment2)
            transaction.setReorderingAllowed(true)
            transaction.addToBackStack("")
            transaction.commit()
        }
//     숨김 버튼 클릭 사용후 텍스트 뷰 전환
        binding.hiddenButton.setOnClickListener {
            transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.baseLayout, fragment3) // 수정된 부분
            transaction.setReorderingAllowed(true)
            transaction.addToBackStack("")
            transaction.commit()
        }

//             뒤로가기 버튼 사용 마이페이지 이동
        binding.btnBack.setOnClickListener {
            intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }

//        글쓰기 버튼 클릭 페이지 이전
        binding.writeButton.setOnClickListener {
            intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
        
    }
}
