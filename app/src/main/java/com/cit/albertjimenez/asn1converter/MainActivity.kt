package com.cit.albertjimenez.asn1converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView

class MainActivity : AppCompatActivity() {

    private val selectionItems = listOf("Morse", "SMS", "ASCII", "Phonetic")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//TODO do the spinner
    }
}

class MySpinnerListener : AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }
}
