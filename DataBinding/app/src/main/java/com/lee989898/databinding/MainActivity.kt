package com.lee989898.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.main_submit_button)
        submitButton.setOnClickListener {
            displayGreeting()
        }
    }

    private fun displayGreeting() {
        val message = findViewById<TextView>(R.id.main_hello_tv)
        val name = findViewById<EditText>(R.id.main_name_et)

        val messageHello = "Hello! "+ name.text
        message.text = messageHello
    }
}