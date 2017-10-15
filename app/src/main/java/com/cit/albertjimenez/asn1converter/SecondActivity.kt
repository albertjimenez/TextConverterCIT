package com.cit.albertjimenez.asn1converter

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cit.albertjimenez.asn1converter.notifications.Notifications
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_second.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

val channelID = "com.cit.albertjimenez.as1converter.ANDROID"
val requestPermission = 100
class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val myNotifier = Notifications(context = applicationContext, channelID = channelID, activity = this )
            myNotifier.callNotification()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.extras.containsKey("INFO"))
            deviceTextView.text= deviceTextView.text.toString().plus(intent.extras.getString("INFO"))

        task6Button.setOnClickListener {
            alert {
                title = getString(R.string.information)
                message = getString(R.string.text_alert_task6)

                customView {
                    button("My Github"){
                        onClick { browse("https://github.com/albertjimenez") }
                    }
                    yesButton { startActivity(intentFor<MainActivity>()) }
                    noButton { toast(getString(R.string.cancel_msg)) }
                }
            }.show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            requestPermission-> {
             if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                 val myNotifier = Notifications(context = this, channelID = channelID, activity = this )
                 myNotifier.callNotification()
             }
            }
        }
    }

}
