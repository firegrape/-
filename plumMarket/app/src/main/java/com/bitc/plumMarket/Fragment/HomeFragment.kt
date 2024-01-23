package com.bitc.plumMarket.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitc.plumMarket.Activity.AlleramActivity
import com.bitc.plumMarket.Activity.BogieActivity
import com.bitc.plumMarket.Activity.DongneaActivity
import com.bitc.plumMarket.R
import com.bitc.plumMarket.databinding.ActivityMain2Binding
import com.bitc.plumMarket.databinding.ActivityMypageBinding

class HomeFragment : Fragment() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityMain2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //              알람 엑티비티 이동 버튼
        binding.btnAlream.setOnClickListener {
            val intent = Intent(requireContext(), AlleramActivity::class.java)
            startActivity(intent)
        }

        //           검색 페이지 이동 버튼
        binding.btnBogie.setOnClickListener {
            val intent = Intent(requireContext(), BogieActivity::class.java)
            startActivity(intent)
        }

        //           동내 위치로 이동 튼
        binding.btnMap.setOnClickListener {
            val intent = Intent(requireContext(), DongneaActivity::class.java)
            startActivity(intent)

        }
    }
}