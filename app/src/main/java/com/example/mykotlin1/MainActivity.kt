package com.example.mykotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mykotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    
        binding.birthdayCardBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Test1ImgActivity::class.java))
        })
        binding.test2DiceBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Test2DiceActivity::class.java))
        })
        binding.helloWorldBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, TestHelloWorldActivity::class.java))
        })
        binding.tipTimeBtn.setOnClickListener {
            startActivity(Intent(this, TipTimeActivity::class.java))
        }
        binding.affirmationBtn.setOnClickListener {
            startActivity(Intent(this, AffirmationActivity::class.java))
        }
    }
}