package com.bitc.plumMarket.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.plumMarket.Data.User
import com.bitc.plumMarket.Adapter.UserAdapter
import com.bitc.plumMarket.databinding.ActivityUserListBinding

class UserListActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserListBinding
    lateinit var  adapter: UserAdapter
    private lateinit var userList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userList = ArrayList()
        adapter = UserAdapter(this,userList)
        binding.userRecycelrView.layoutManager = LinearLayoutManager(this)
        binding.userRecycelrView.adapter = adapter
        userList.add(0, User("윤성훈","몰라","1"))

        userList.add(1, User("박수연","몰라","2"))
        userList.add(2, User("나찬해","몰라","3"))
        userList.add(3, User("장석훈","몰라","4"))
        userList.add(4, User("김경은","몰라","5"))

    }
}