package com.bitc.plumMarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitc.plumMarket.databinding.ActivityMypageBinding

class MyFragment : Fragment() {

    private lateinit var binding: ActivityMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGansim.setOnClickListener {
            val intent = Intent(requireContext(), GansimActivity::class.java)
            startActivity(intent)
        }

        binding.btnPanmae.setOnClickListener {
            val intent = Intent(requireContext(), PanmaeActivity::class.java)
            startActivity(intent)
        }

        binding.btnGumae.setOnClickListener {
            val intent = Intent(requireContext(), GumaeActivity::class.java)
            startActivity(intent)
        }

        binding.profilePicture.setOnClickListener {
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnMypageProfile.setOnClickListener {
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}