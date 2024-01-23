package com.bitc.plumMarket.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitc.plumMarket.databinding.ActivityUserListBinding


class ChatFragment : Fragment() {

    private lateinit var binding: ActivityUserListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

}