package com.example.mykotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mykotlin1.databinding.ActivityTipTimeBinding

class TipTimeActivity : AppCompatActivity() {
  private lateinit var binding: ActivityTipTimeBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // 视图绑定
    binding = ActivityTipTimeBinding.inflate(layoutInflater)
    setContentView(binding.root)
    
    binding.calculateButton.setOnClickListener { calculateTip() }
  }
  
  // 计算小费
  private fun calculateTip() {
    val stringInTextField = binding.costOfServiceEditText.text.toString()
    val cost = stringInTextField.toDoubleOrNull()
    
    if (cost == null || cost == 0.0) {
      Toast.makeText(applicationContext, "请输入消费金额", Toast.LENGTH_SHORT).show()
      return
    }
    
    // 获取小费费率
    val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
      R.id.option_twenty_percent -> 0.20
      R.id.option_eighteen_percent -> 0.18
      else -> 0.15
    }
    
    var tip = tipPercentage * cost
    
    // 四舍五入
    val roundUp = binding.roundUpSwitch.isChecked
    if (roundUp) {
      tip = kotlin.math.ceil(tip)
    }
    
    binding.tipResult.text = "小费金额: $tip"
  }
}