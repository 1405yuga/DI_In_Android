package com.example.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        val notificationHelper = NotificationHelper(applicationContext)
        notificationHelper.createNotificationChannel()

        try {
            val inputData = inputData.getString("INPUT_KEY")
            Thread.sleep(3000)
            notificationHelper.showNotification("MyWorker notification", inputData.toString())
            println("Received input : $inputData")
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.failure()
        }
        return Result.success()
    }
}