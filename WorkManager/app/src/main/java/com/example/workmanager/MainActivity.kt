package com.example.workmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.workManagerButton.setOnClickListener { performWork() }
        binding.notificationButton.setOnClickListener { createAndShowNotification() }
    }

    private fun createAndShowNotification() {
        val notificationHelper = NotificationHelper(this)
        notificationHelper.createNotificationChannel()
        notificationHelper.showNotification("Test title", "Hi , new notification here!")
        Log.d(TAG, "Notification shown!")
    }

    private fun performWork() {
//        prepare Input
        val someInput = Data.Builder()
            .putString("INPUT_KEY", "Hello there!")
            .build()
//        define constraints
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
//        create request
        val workerRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setInputData(someInput)
            .setConstraints(constraints)
            .build()

        //enqueue the work
        WorkManager.getInstance(context = this).enqueue(workerRequest)
    }
}