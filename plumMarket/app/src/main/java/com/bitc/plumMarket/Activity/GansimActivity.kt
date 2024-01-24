package com.bitc.plumMarket.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitc.plumMarket.Adapter.ListAdapter
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.MySharedpreferences
import com.bitc.plumMarket.R
import com.bitc.plumMarket.RetrofitBuilder
import com.bitc.plumMarket.databinding.ActivityGansimBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GansimActivity : AppCompatActivity() {
    val id = MySharedpreferences.getUserId(applicationContext)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGansimBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
