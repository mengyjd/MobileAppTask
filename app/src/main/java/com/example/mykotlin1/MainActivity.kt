package com.example.mykotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val test1ImgBtn: Button = findViewById(R.id.test1_img_btn)
        val test2DiceBtn: Button = findViewById(R.id.test2_dice_btn)
        val helloWorldBtn: Button = findViewById(R.id.hello_world_btn)
        
        test1ImgBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Test1ImgActivity::class.java))
        })
        test2DiceBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Test2DiceActivity::class.java))
        })
        helloWorldBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, TestHelloWorldActivity::class.java))
        })
    }
}