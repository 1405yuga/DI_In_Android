package com.example.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        performWork()
//        createAndShowNotification()

    }

    private fun createAndShowNotification() {
        val notificationHelper = NotificationHelper(this)
        notificationHelper.createNotificationChannel()
        notificationHelper.showNotification("Test title", "Hi , new notification here!")
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