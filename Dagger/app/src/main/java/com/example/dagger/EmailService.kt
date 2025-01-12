package com.example.dagger

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

//Loose coupling-------------
interface NotificationService {
    fun send(to: String, from: String, body: String)
}

@Singleton
class EmailService @Inject constructor() : NotificationService {
    val TAG = this.javaClass.simpleName
    override fun send(to: String, from: String, body: String) {
        Log.d(TAG, "email sent")
    }
}

class MessageService @Inject constructor() : NotificationService {
    val TAG = this.javaClass.simpleName
    override fun send(to: String, from: String, body: String) {
        Log.d(TAG, "message sent")
    }
}

//Manual------------
// class EmailService {
//    val TAG = this.javaClass.simpleName
//    fun send(to: String, from: String, body: String) {
//        Log.d(TAG, "email sent")
//    }
//}