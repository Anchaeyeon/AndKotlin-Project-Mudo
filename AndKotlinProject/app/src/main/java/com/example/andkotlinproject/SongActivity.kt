package com.example.andkotlinproject

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
        R.drawable.seo7,
        R.drawable.seo7,
        R.drawable.seo6
    )

    var songTitle = arrayOf(
        "순정마초", "나만 부를 수 있는 노래", "바람났어", "죽을래 사귈래",
        "찹쌀떡", "정주나요", "압구정 날라리", "말하는 대로", "흔들어주세요"
    )

    var singer = arrayOf(
        "파리돼지앵", "바닷길", "GG", "센치한 하하",
        "센치한 하하", "스윗콧소로우", "처진 달팽이", "처진 달팽이", "철싸"
    )

    var songName = arrayOf(
        "정형돈 & 정재형", "길 & 바다", "박명수 & G-DRAGON (feat.박봄)", "하하 & 10CM",
        "하하 & 10CM", "정준하 & 스윗소로우", "유재석 & 이적", "유재석 & 이적", "노홍철 & 싸이"
    )

    var songExplain = arrayOf(
        "24인조의 오케스트라와 함께하는 정열적이고 드라마틱한 탱고 선율의 곡♫",
        "길과 바다의 공감을 통해 탄생한 발라드 곡. 바다의 맑은 음색을 살려주는 빅밴드 연주가 인상적!",
        "GD의 부추김에 늦바람난 민서 아비 마음을 재치있게 풀어낸 신바람 나는 일렉트로닉 힙합곡♧",
        "사랑을 갈구하는 청년의 삐뚤어진 마음을 장난스러운 가사로 풀어낸 로큰롤 넘버♩",
        "밝고 귀여운 팝의 느낌이 강한 레게풍의 노래. 나열할 수 있는 모든 음식 맛을 합한 만큼 연인을 사랑한다는 고백송♡",
        "순진남의 간절한 마음을 경쾌하고 귀엽게 표현한 러브송♥",
        "압구정 무도장을 누비던 청년 유재석의 뜨거운 밤 이야기를 담은 복고 댄스곡♬♪",
        "힘들었던 20대를 돌아보는 유재석의 자전적 이야기가 담긴 희망가",
        "이별한 이들에게 파이팅을 전하는 로큰롤 방방 댄스곡 ☆"
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

        // 이미지 & 제목 & 가수 보여주기
        val datas = mutableListOf<Song>()
        for (i in 0 until songPoster.size) {
            val m = Song(ContextCompat.getDrawable(this, songPoster[i])!!, songTitle[i], singer[i])
            datas.add(m)
        }

        // GridLayoutManager로 변경
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = SongAdapter(datas)
        binding.recyclerView.adapter = adapter

        adapter.itemClick = object : SongAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val dialogView = layoutInflater.inflate(R.layout.dialog, null)
                val dlg = AlertDialog.Builder(this@SongActivity)

                val img = dialogView.findViewById<ImageView>(R.id.img)
                val title = dialogView.findViewById<TextView>(R.id.title)
                val team = dialogView.findViewById<TextView>(R.id.team)
                val name = dialogView.findViewById<TextView>(R.id.name)
                val explain = dialogView.findViewById<TextView>(R.id.explain)

                img.setImageResource(songPoster[position])
                title.text = songTitle[position]
                team.text = singer[position]
                name.text = songName[position]
                explain.text = songExplain[position]

                dlg.setView(dialogView)
                dlg.setPositiveButton("완료", null)
                dlg.show()
            }
        }

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
