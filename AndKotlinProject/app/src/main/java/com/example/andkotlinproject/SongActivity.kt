package com.example.andkotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andkotlinproject.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySongBinding // ViewBinding 사용 예시

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바 세팅
        setSupportActionBar(binding.toolbar)
        //Actionbar에서 뒤로가기 버튼 활성화
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 전달된 데이터 받기
        val posterTitle = intent.getStringExtra("Gayojae_Title")
        binding.gayoTitle.text = posterTitle
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        onBackPressedDispatcher.onBackPressed() //뒤로가기
        return true
    }
}