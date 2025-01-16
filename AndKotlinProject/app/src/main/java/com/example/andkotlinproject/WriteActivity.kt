package com.example.andkotlinproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andkotlinproject.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    lateinit var binding : ActivityWriteBinding
    val myDB: MyDBHelper = MyDBHelper(this)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 툴바 세팅
        setSupportActionBar(binding.toolbar)

        // Actionbar에서 뒤로가기 버튼 활성화
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.writeBtn.setOnClickListener {
            val team = binding.cheerTeam.text.toString()
            val name = binding.userName.text.toString()
            val text = binding.cheerText.text.toString()
            val write = Write(team, name, text)
            myDB.addTodo(write)
            Toast.makeText(this, "응원의 메세지가 작성되었습니다", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MessageActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        onBackPressedDispatcher.onBackPressed() // 뒤로가기
        return true
    }
}