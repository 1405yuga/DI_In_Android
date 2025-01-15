package com.example.workmanager

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class NotificationHelper(private val context: Context) {
    private val CHANNEL_ID = "some_channel_Id"

    //create notification channel
    fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Work notification",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "This is example notification"
        }

        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    //showNotification
    fun showNotification(title: String, message: String) {
        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_diamond_24)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        //check-permissions
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            NotificationManagerCompat.from(context)
                .notify(
                    Random.nextInt(), // notification with same id gets overridden
                    notificationBuilder.build()
                )
        } else {
            Toast.makeText(context, "Grant permission for notifications", Toast.LENGTH_LONG).show()
        }
    }


}