package com.example.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService: Service() {

    init {
        Log.d(TAG, "Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service Started")
        val name = intent?.getStringExtra(NAME)
        val marks = intent?.getIntExtra(MARKS, 0)
        Log.i(TAG, "name is $name , marks : $marks")

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        Log.d(TAG, "Destroying..")
        super.onDestroy()
    }

    companion object {
        const val TAG = "BACKGROUND"
        const val NAME = "NAME"
        const val MARKS = "TOTAL MARKS"
    }
}