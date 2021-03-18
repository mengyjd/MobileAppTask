package com.example.mykotlin1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.CountDownTimer
import android.widget.Toast


class Dice (private val sideSum: Int) : AppCompatActivity()  {
  private val sideStart: Int = 1
  private val diceRange: IntRange = sideStart..sideSum
  private var animationIsDone: Boolean = true // 动画是否完成
  private val animationTime: Long = 800 // 动画时间 毫秒
  private val intervalTime: Long = 50 // 动画间隔时间 毫秒
  
  fun roll(): Int {
    return diceRange.random()
  }
  
  fun start(context: Context) {
    println("animationIsDone=========$animationIsDone")
    // 如果动画未完成直接返回
    if (!animationIsDone) {
      Toast.makeText(context, "正在摇骰子, 请稍候...", Toast.LENGTH_SHORT).show()
      return
    }
  
    animationIsDone = false
    
    var loopCount = sideStart
    println("========开始动画==========")
  
    object : CountDownTimer(animationTime, intervalTime) {
      override fun onTick(millisUntilFinished: Long) {
        val drawableResource = getDrawableResource(loopCount)
        sendUpdateDiceImgBroadcast(context,drawableResource)
        
        if (loopCount >= sideSum) {
          loopCount = sideStart
        } else {
          loopCount++
        }
      }
    
      override fun onFinish() {
        val drawableResource = getDrawableResource(roll())
        sendUpdateDiceImgBroadcast(context,drawableResource)
        animationIsDone = true
      }
    }.start()
  }
  
  private fun sendUpdateDiceImgBroadcast(context: Context, drawableResource: Int) {
    val intent = Intent()
    intent.action = "UPDATE_DICE_IMG"
    intent.putExtra("img", drawableResource)
    context.sendBroadcast(intent)
  }
  
  private fun getDrawableResource(num: Int): Int {
    return when(num) {
      1 -> R.drawable.dice_1
      2 -> R.drawable.dice_2
      3 -> R.drawable.dice_3
      4 -> R.drawable.dice_4
      5 -> R.drawable.dice_5
      else -> R.drawable.dice_6
    }
  }
}