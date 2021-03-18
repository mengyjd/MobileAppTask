package com.example.mykotlin1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class Test2DiceActivity : AppCompatActivity() {
  
  private lateinit var diceImg: ImageView
  private lateinit var rollDiceBtn: Button
  private var myReceiver: MyReceiver? = null
  private var intentFilter: IntentFilter? = null
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.test2_dice)
  
    initBroadcast()
    initView()
    
    val dice = Dice(6)
    
    rollDiceBtn.setOnClickListener(View.OnClickListener {
      dice.start(this)
    })
  }
  
  override fun onDestroy() {
    super.onDestroy()
    unregisterReceiver(myReceiver)
  }
  
  private fun initBroadcast() {
    myReceiver = MyReceiver()
    intentFilter = IntentFilter()
    intentFilter!!.addAction("UPDATE_DICE_IMG")
    registerReceiver(myReceiver, intentFilter)
  }
  
  private fun initView() {
    diceImg = findViewById(R.id.dice_image)
    rollDiceBtn = findViewById(R.id.roll_dice_btn)
  }
  
  private fun updateDiceImage(res: Int) {
    diceImg.setImageResource(res)
  }
  
  private inner class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
      if (intent.action == "UPDATE_DICE_IMG") {
        val img = intent.getIntExtra("img", 0)
        updateDiceImage(img)
      }
    }
  }
}