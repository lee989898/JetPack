package com.example.notification

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import com.example.notification.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput() {
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null) {
            val inputString = remoteInput.getCharSequence("key_reply").toString()
            binding.resultTextView.text = inputString

            val channelID = "com.example.notification.channel1"
            val notificationId = 45

            val repliedNotification = NotificationCompat.Builder(this, channelID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("You reply received")
                .build()

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId, repliedNotification)
        }
    }

}