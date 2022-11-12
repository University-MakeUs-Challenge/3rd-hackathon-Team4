package com.example.client

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.client.databinding.ActivitySubtitleBinding

class SubtitleActivity:AppCompatActivity() {
    private lateinit var binding:ActivitySubtitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubtitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
           var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}