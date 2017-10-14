package com.cit.albertjimenez.asn1converter

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG).show() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Log.d("INFO: ", intent.extras.getString("INFO"))
        if (intent.extras.containsKey("INFO"))
            deviceTextView.text= deviceTextView.text.toString().plus(intent.extras.getString("INFO"))
    }

}
