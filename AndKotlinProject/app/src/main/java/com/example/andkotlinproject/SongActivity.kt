package com.example.andkotlinproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andkotlinproject.databinding.ActivityMainBinding
import com.example.andkotlinproject.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySongBinding // ViewBinding 사용 예시

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전달된 데이터 받기
        val posterTitle = intent.getStringExtra("Gayo_Title")
        binding.gayoTitle.text = posterTitle  // 전달된 제목을 TextView에 표시
    }
}
