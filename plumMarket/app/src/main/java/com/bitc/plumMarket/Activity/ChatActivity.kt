package com.bitc.plumMarket.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.plumMarket.Data.Message
import com.bitc.plumMarket.Adapter.MessageAdapter
import com.bitc.plumMarket.MySharedpreferences
import com.bitc.plumMarket.R
import com.bitc.plumMarket.databinding.ActivityChatBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChatActivity : AppCompatActivity() {
    private lateinit var messageList: ArrayList<Message>
    val database = Firebase.database("https://androidchat-c4b8a-default-rtdb.asia-southeast1.firebasedatabase.app")
    val myRef = database.getReference("first")
    private lateinit var receiverName: String
    private lateinit var receiverUid: String

    private lateinit var receiverRoom: String //받는 대화방
    private lateinit var senderRoom: String //보낸 대화방

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)	//툴바 사용 설정

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)	//왼쪽 버튼 사용설정(기본은 뒤로가기)

        supportActionBar!!.setDisplayShowTitleEnabled(true)		//타이틀 보이게 설정


        messageList = ArrayList()
        val messageAdapter: MessageAdapter = MessageAdapter(this, messageList)

        //RecyclerView
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.chatRecyclerView.adapter = messageAdapter

        //보내는 유저
        val senderUid = MySharedpreferences.getUserIdx(this)

        //넘어온 데이터 변수에 담기
        receiverName = intent.getStringExtra("nick").toString()
        receiverUid = intent.getStringExtra("uId").toString()

        //보낸이방
        senderRoom = receiverUid + senderUid

        //받는이방
        receiverRoom = senderUid + receiverUid


        //액션바에 상대방 이름 보여주기
        supportActionBar?.title = receiverName

        binding.sendBtn.setOnClickListener{
            val message = binding.messageEdit.text.toString()
            val messageObject = Message(message, senderUid)

            myRef.child("second").child(senderRoom).child("third").push()
                .setValue(messageObject).addOnSuccessListener {
                    myRef.child("second").child(receiverRoom).child("third").push()
                        .setValue(messageObject)
                }
        }

        //메시지 가져오기
        myRef.child("second").child(senderRoom).child("third")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    messageList.clear()

                    for(postSnapshat in snapshot.children){

                        val message = postSnapshat.getValue(Message::class.java)
                        messageList.add(message!!)
                    }
                    //적용
                    messageAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainaction, menu)		//작성한 메뉴파일 설정
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId){
            android.R.id.home->{	//각 버튼 마다 스낵바 메세지로 기능 구현
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_search->{

            }

        }

        return super.onOptionsItemSelected(item)
    }
}