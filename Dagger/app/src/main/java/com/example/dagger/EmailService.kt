package com.example.dagger

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor() {
    val TAG = this.javaClass.simpleName
    fun send(to: String, from: String, body: String) {
        Log.d(TAG, "email sent")
    }
}

//Manual------------
// class EmailService {
//    val TAG = this.javaClass.simpleName
//    fun send(to: String, from: String, body: String) {
//        Log.d(TAG, "email sent")
//    }
//}