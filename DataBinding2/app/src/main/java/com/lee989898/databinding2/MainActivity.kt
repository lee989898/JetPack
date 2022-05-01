package com.lee989898.databinding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lee989898.databinding2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val student = getStudent()
        binding.nameText.text = student.name
        binding.emailText.text = student.email
    }

    private fun getStudent():Student{
        return Student(1,"Alex","alex@gmail.com")
    }
}
