package com.bitc.plumMarket.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitc.plumMarket.databinding.ActivityChatBinding


class ChatFragment : Fragment() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityChatBinding.inflate(inflater, container, false)
        return binding.root
    }

}