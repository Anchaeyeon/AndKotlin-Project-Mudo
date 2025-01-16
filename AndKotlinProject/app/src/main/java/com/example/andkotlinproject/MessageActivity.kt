package com.example.andkotlinproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        /*  바인딩 사용 예   : bindig.id이름.XXX
        binding.btn.setOnClickListener {
            binding.txtResult.text = "계산결과"
        }
       */
    }
}