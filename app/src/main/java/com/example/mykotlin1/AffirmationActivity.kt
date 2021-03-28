package com.example.mykotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlin1.adapter.ItemAdapter
import com.example.mykotlin1.data.Datasource
import com.example.mykotlin1.databinding.ActivityAffirmationBinding

class AffirmationActivity : AppCompatActivity() {
  private lateinit var binding: ActivityAffirmationBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    binding = ActivityAffirmationBinding.inflate(layoutInflater)
    setContentView(binding.root)
  
    val myDataset = Datasource().loadAffirmations()
  
    binding.recyclerView.adapter = ItemAdapter(this, myDataset)
  
    binding.recyclerView.setHasFixedSize(true)
  }
}