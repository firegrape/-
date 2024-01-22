package com.bitc.plumMarket.DB

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bitc.plumMarket.MainActivity
import com.bitc.plumMarket.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Login()



        }
    fun Login() {
        Log.d("ysh", "133")

        binding.btnLogin.setOnClickListener {
            Log.d("ysh", "확인중")
            var et_id = binding.edId.text.toString()
            var et_pass = binding.edPass.text.toString()
            if (et_id.isNullOrBlank() || et_pass.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            } else {
                Log.d("ysh", "확인")
                MySharedpreferences.setUserId(this, et_id)
                MySharedpreferences.setUserPass(this, et_pass)
                Toast.makeText(
                    this,
                    "${MySharedpreferences.getUserId(this)}님 로그인 되었습니다.",
                    Toast.LENGTH_SHORT
                ).show()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

}