package com.example.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        prepare Input
        val someInput = Data.Builder()
            .putString("INPUT_KEY", "Hello there!")
            .build()

//        create request
        val workerRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setInputData(someInput)
            .build()

        //enqueue the work
        WorkManager.getInstance(context = this).enqueue(workerRequest)
    }
}