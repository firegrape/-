package com.bitc.plumMarket.DB

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bitc.plumMarket.DTO.User
import com.bitc.plumMarket.databinding.ActivityVollyBinding
import com.google.gson.Gson
import org.json.JSONObject

class VollyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityVollyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val queue = Volley.newRequestQueue(this)

        binding.btnVolly.setOnClickListener {
            var jsonObject: JSONObject = JSONObject()
            val url = "http://10.0.2.2:8080/rest"
            val jsonRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
                jsonObject,
                {
                    Log.d("csy-volley", "json 방식으로 데이터 가져오기 성공")


                    val gson = Gson()

                    val user : User = gson.fromJson(it.toString(),User::class.java)
                    val id = user.id
                    val pw = user.pw

                    Log.d("ysh", "${id}${pw}")


//          Log.d("csy-volley", "${kobis.boxOfficeResult?.dailyBoxOfficeList?.get(0)?.movieNm}")
                },
                { error ->
                    Log.d("csy-volley", "json 방식으로 데이터 가져오기 오류\nerrer: $error")
                }
            )
            queue.add(jsonRequest)
        }

        binding.btnJson.setOnClickListener {
            val url = "http://10.0.2.2:8080/android"
            val stringRequest = object : StringRequest(Request.Method.POST, url,
                Response.Listener<String>{
                    Log.d("ysh-volley","서버데이터 가져옴")
                    binding.tvVolley.text = it

                },
                Response.ErrorListener { error ->
                    // 에러 처리
                    Log.d("ysh-volley", "error:$error")
                }) {
                override fun getParams(): MutableMap<String, String> {
                    // POST 요청 시 보낼 데이터 설정
                    val params = HashMap<String, String>()
                    params["id"] = binding.editId.text.toString()
                    params["pw"] = binding.editPw.text.toString()
                    Log.d("ysh","${params} ${url}")
                    return params
                }
            }
            queue.add(stringRequest)
        }
//        binding.btnVolly.setOnClickListener {
//            val url = "http://10.0.2.2:8080/android"
//        }



        binding.btnVollyUrlClear.setOnClickListener {
            binding.etServerUrl.setText("")
        }
    }
}