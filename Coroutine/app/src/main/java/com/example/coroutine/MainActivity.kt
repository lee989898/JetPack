package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }

        binding.btnDownloadUserData.setOnClickListener {
            downloadUserData()
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}
