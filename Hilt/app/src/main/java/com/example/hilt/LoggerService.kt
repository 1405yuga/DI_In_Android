package com.example.hilt

import android.util.Log
import javax.inject.Inject

class LoggerService @Inject constructor() {
    val TAG = this.javaClass.simpleName

    fun log(message: String) {
        Log.d(TAG, message)
    }
}