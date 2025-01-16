package com.example.andkotlinproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.andkotlinproject.databinding.ActivityMainBinding
import com.example.andkotlinproject.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 툴바 설정
        setSupportActionBar(binding.toolbar)

        // ActionBarDrawerToggle로 네비게이션 아이콘 연결
        val toggle = ActionBarDrawerToggle(
            this, binding.main, binding.toolbar,
            R.string.navi_go_gayo, R.string.navi_go_message
        )
        binding.main.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = false // 기본 아이콘 비활성화
        toggle.syncState() //네비게이션 아이콘 표시

        binding.mainDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.goGayo -> {
                    Toast.makeText(this, "가요제 보러가기가 클릭되었습니다", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.goMessage -> {
                    Toast.makeText(this, "메시지 남기러가기가 클릭되었습니다", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MessageActivity::class.java)
                    startActivity(intent)
                }
            }
            binding.main.closeDrawer(GravityCompat.START) //내비게이션 닫기
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
                binding.main.openDrawer(GravityCompat.START) //NavigationView 열기
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}