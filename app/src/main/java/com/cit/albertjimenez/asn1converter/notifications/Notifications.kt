package com.cit.albertjimenez.asn1converter.notifications

import android.Manifest
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat
import com.cit.albertjimenez.asn1converter.R
import com.cit.albertjimenez.asn1converter.SecondActivity


/**
 * Created by Albert Jiménez on 15/10/17 for Programming Mobile Devices.
 */
class Notifications(private val context: Context,
                    private val channelID: String, private val activity: SecondActivity) {

    private var resultPermission = 100

    fun callNotification() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:0210000001")
        val pendingIntent = PendingIntent.getActivity(context, 0, callIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notificationBuilder = NotificationCompat.Builder(context, channelID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(context.resources.getString(R.string.app_name))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)


        val inboxStyle = NotificationCompat.InboxStyle()
        notificationBuilder.setStyle(inboxStyle)
        inboxStyle.setBigContentTitle(context.getString(R.string.notification_text))
        inboxStyle.addLine("Call")
        notificationBuilder.setStyle(inboxStyle)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val NOTIFICATION_ID = 101
        if (checkPermission())
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
        else
            grantPermissions()
    }


    private fun checkPermission(): Boolean {
        val permission = "android.permission.CALL_PHONE"
        return context.checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun grantPermissions() {

        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.CALL_PHONE)) {
            } else
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CALL_PHONE),
                        resultPermission)
        }
    }
}


