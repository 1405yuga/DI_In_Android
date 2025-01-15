package com.example.workmanager

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val TAG = this::class.simpleName
    private val notificationHelper = NotificationHelper(this)

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "new token $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        message.notification.let {
            Log.d(
                TAG,
                if (it == null) "push-notification is null"
                else "push-notification = ${it.title} | ${it.body}"
            )
            if (it != null) {
                notificationHelper.createNotificationChannel()
                notificationHelper.showNotification(
                    title = it.title.toString(),
                    message = it.body.toString()
                )
            }
        }
    }
}