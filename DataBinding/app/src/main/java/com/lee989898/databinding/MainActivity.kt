package com.lee989898.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lee989898.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mainSubmitButton.setOnClickListener {
            displayGreeting()
        }
    }

    private fun displayGreeting() {
        binding.apply {
            mainHelloTv.text = "안녕하세요! " + mainNameEt.text
        }
    }
}