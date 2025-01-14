package com.example.hilt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var loggerService1: LoggerService

    @Inject
    lateinit var loggerService2: LoggerService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "logger 1 : ${loggerService1.hashCode()}")
        Log.d(TAG, "logger 2 : ${loggerService2.hashCode()}")
    }
}