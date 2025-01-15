package com.example.andkotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andkotlinproject.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*  바인딩 사용 예   : bindig.id이름.XXX
        binding.btn.setOnClickListener {
            binding.txtResult.text = "계산결과"
        }
       */
    }
}