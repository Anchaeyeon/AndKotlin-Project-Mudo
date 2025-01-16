package com.example.andkotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andkotlinproject.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWriteBinding
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
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        onBackPressedDispatcher.onBackPressed() // 뒤로가기
        return true
    }
}