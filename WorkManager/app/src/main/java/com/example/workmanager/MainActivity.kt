package com.example.workmanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.workmanager.NotifyWorker.Companion.Progress
import com.example.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_COUNT_VALUE = "key_count"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        if (intent.hasExtra("notification_id")){
            val notiftcationId = intent.getIntExtra("notification_id", 0)

        }
        startWork()


//        binding.button.setOnClickListener {
//
////            setOneTimeWorkRequest()
////            setPeriodicWorkRequest()
//        }
    }

    @SuppressLint("EnqueueWork")
    private fun setOneTimeWorkRequest() {
        val workManager = WorkManager.getInstance(applicationContext)

        val data: Data = Data.Builder()
            .putInt(KEY_COUNT_VALUE, 125)
            .build()

        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                OneTimeWorkRequest.MAX_BACKOFF_MILLIS,
                TimeUnit.MICROSECONDS
            )
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        val filteringRequest = OneTimeWorkRequest.Builder(FilteringWorker::class.java)
            .build()
        val compressingRequest = OneTimeWorkRequest.Builder(CompressingWorker::class.java)
            .build()
        val downloadingWorker = OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
            .build()
        val deleteWorker = OneTimeWorkRequest.Builder(DeleteWorker::class.java)
            .build()

//        val paralleWorks = mutableListOf<OneTimeWorkRequest>()
//        paralleWorks.add(downloadingWorker)
//        paralleWorks.add(filteringRequest)

        val chain1 = workManager.beginWith(compressingRequest).then(downloadingWorker)
        val chain2 = workManager.beginWith(filteringRequest).then(deleteWorker)
        val chain3 = WorkContinuation.combine(listOf(chain1,chain2)).then(uploadRequest)
        chain3.enqueue()

//        workManager.enqueue(uploadRequest)
//        workManager.beginWith(paralleWorks)
//            .then(compressingRequest)
//            .then(uploadRequest)
//            .enqueue()


        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this, Observer {
            binding.textView.text = it.state.name
            if (it.state.isFinished){
                val data = it.outputData
                val message = data.getString(UploadWorker.KEY_WORKER)
                Toast.makeText(applicationContext, message.toString(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun createConstraints() = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresCharging(false)
        .setRequiresBatteryNotLow(true)
        .build()

    private fun createWorkRequest() = PeriodicWorkRequestBuilder<NotifyWorker>(16, TimeUnit.MINUTES)
        .addTag("notify")
        .setConstraints(createConstraints())
        .build()

    private fun startWork() {
        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(
                "Notify Work",
                ExistingPeriodicWorkPolicy.REPLACE,
                createWorkRequest()
            )


        WorkManager.getInstance(applicationContext)
            // requestId is the WorkRequest id
            .getWorkInfosByTagLiveData("notify")
            .observe(this) {
                val progress = it[0].progress
                val value = progress.getInt(Progress, 0)
                binding.textView.text = value.toString()
                binding.progressBar.progress = value
            }
    }

    private fun setPeriodicWorkRequest(){
        val periodicWorkRequest = PeriodicWorkRequest.Builder(DownloadingWorker::class.java, 16, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequest)
    }
}