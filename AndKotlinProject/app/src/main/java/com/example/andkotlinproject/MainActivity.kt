package com.example.andkotlinproject

import android.graphics.Movie
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andkotlinproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var poster = arrayOf<Int>(
        R.drawable.poster1,
        R.drawable.poster2,
        R.drawable.poster3
    )

    var title = arrayOf(
        "서해안 고속도로 가요제", "자유로 가요제", "영동고속도로 가요제"
    )

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<Poster>()
        for (i in 0 until poster.size) {
            var m = Poster(ContextCompat.getDrawable(this, poster[i])!!, title[i])
            datas.add(m)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PosterAdapter(datas)
        binding.recyclerView.adapter = adapter


        // 툴바 설정
        setSupportActionBar(binding.toolbar)

        // ActionBarDrawerToggle로 네비게이션 아이콘 연결
        val toggle = ActionBarDrawerToggle(
            this, binding.whole, binding.toolbar,
            R.string.navi_go_gayo, R.string.navi_go_message
        )
        binding.whole.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = false // 기본 아이콘 비활성화
        toggle.syncState() //네비게이션 아이콘 표시

        binding.mainDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.goGayo-> { Toast.makeText(this, "가요제 보러가기가 클릭되었습니다", Toast.LENGTH_SHORT).show() }
                R.id.goMessage -> { Toast.makeText(this, "메시지 남기러가기가 클릭되었습니다", Toast.LENGTH_SHORT).show()}
            }
            binding.whole.closeDrawer(GravityCompat.START) //내비게이션 닫기
            true //true를 반환하면 클릭 이벤트가 처리됨
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_navigation -> {
                binding.whole.openDrawer(GravityCompat.START) //NavigationView 열기
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}