package com.example.andkotlinproject

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andkotlinproject.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    var songPoster = arrayOf<Int>(
        R.drawable.seo1,
        R.drawable.seo2,
        R.drawable.seo3,
        R.drawable.seo4,
        R.drawable.seo4,
        R.drawable.seo5,
        R.drawable.seo6,
        R.drawable.seo7,
        R.drawable.seo7
    )

    var songTitle = arrayOf(
        "순정마초", "나만 부를 수 있는 노래", "바람났어", "죽을래 사귈래",
        "찹쌀떡", "정주나요", "흔들어 주세요", "압구정 날라리", "말하는 대로"
    )

    var singer = arrayOf(
        "파리돼지앵", "바닷길", "GG", "센치한 하하",
        "센치한 하하", "스윗콧소로우", "철싸", "처진 달팽이", "처진 달팽이"
    )

    private lateinit var binding : ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent로부터 데이터 받기
        val gayojaeTitle = intent.getStringExtra("Gayojae_Title")

        // 받은 데이터를 UI에 설정
        binding.gayoTitle.text = gayojaeTitle

        // 이미지 & 제목 보여주기
        val datas = mutableListOf<Song>()
        for (i in 0 until songPoster.size) {
            val m = Song(ContextCompat.getDrawable(this, songPoster[i])!!, songTitle[i], singer[i])
            datas.add(m)
        }

        // GridLayoutManager로 변경
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = SongAdapter(datas)
        binding.recyclerView.adapter = adapter

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
