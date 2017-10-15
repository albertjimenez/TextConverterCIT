package com.cit.albertjimenez.asn1converter

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_second.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG).show() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.extras.containsKey("INFO"))
            deviceTextView.text= deviceTextView.text.toString().plus(intent.extras.getString("INFO"))

        task6Button.setOnClickListener {
            alert {
                title = getString(R.string.information)
                message = "This is an alert for task 6. Do you want to go back to previous activity?"

                customView {
                    button("My Github"){
                        onClick { browse("https://github.com/albertjimenez") }
                    }
                    yesButton { startActivity(intentFor<MainActivity>()) }
                    noButton { toast("You pressed cancel") }
                }
            }.show()
        }
    }

}
