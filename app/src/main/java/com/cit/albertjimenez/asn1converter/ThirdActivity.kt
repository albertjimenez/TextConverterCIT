package com.cit.albertjimenez.asn1converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*
import org.jetbrains.anko.intentFor
import java.util.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        goback.setOnClickListener { startActivity(intentFor<MainActivity>("DATE"
                to GregorianCalendar.getInstance().time.toString())) }
    }
}
