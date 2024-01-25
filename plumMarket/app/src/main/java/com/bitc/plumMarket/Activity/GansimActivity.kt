package com.bitc.plumMarket.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.plumMarket.Adapter.GansimAdapter
import com.bitc.plumMarket.Data.GansimData
import com.bitc.plumMarket.Data.LoginData
import com.bitc.plumMarket.MySharedpreferences
import com.bitc.plumMarket.RetrofitBuilder

import com.bitc.plumMarket.databinding.ActivityGansimBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GansimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGansimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = MySharedpreferences.getUserId(applicationContext)
        val items = mutableListOf<GansimData>()

        RetrofitBuilder.api.GansimList(userId).enqueue(object: Callback<List<GansimData>>{
            override fun onResponse(call: Call<List<GansimData>>, response: Response<List<GansimData>>) {
                val GansimAddList: List<GansimData>? = response.body()

                val sharedPref =
                    getSharedPreferences("basket_list", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                val gson = Gson()
                val json = gson.toJson(GansimAddList)
                editor.putString("BasketList", json)
                editor.apply()

                val type = object : TypeToken<List<GansimData>>() {}.type
                val GansimInfoList = gson.fromJson<List<GansimData>>(json, type)

                for (dumGansim in GansimInfoList) {
                    dumGansim.let {
                        items.add(GansimData(it.fav_list_idx,it.favTitle,it.fav_money))
                    }
                }

                val gansimAdapter = GansimAdapter(items)

                binding.recyclerView.itemAnimator = null
                binding.recyclerView.layoutManager = LinearLayoutManager(this@GansimActivity)
                binding.recyclerView.adapter = gansimAdapter

            }

            override fun onFailure(call: Call<List<GansimData>>, t: Throwable) {
                Log.d("error", t.localizedMessage)
            }
        })


    }
}

