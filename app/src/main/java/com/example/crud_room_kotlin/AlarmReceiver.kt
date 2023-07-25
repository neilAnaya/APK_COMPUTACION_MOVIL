package com.example.crud_room_kotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.core.app.NotificationCompat
import android.net.Uri

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val customSoundUri = Uri.parse("android.resource://${context.packageName}/${R.raw.mariobros}")

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "alarm_channel_id"
        val channelName = "Alarm Channel"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val smallIcon = R.drawable.campana
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Alarma")
            .setContentText("Nueva tarea disnponible.")
            .setSmallIcon(smallIcon)
            .setAutoCancel(false)
            .setSound(customSoundUri)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

        val notification = notificationBuilder.build()
        notificationManager.notify(0, notification)

        /*val mp = MediaPlayer.create(context, R.raw.mariobros)
        mp.start()*/
    }
}
