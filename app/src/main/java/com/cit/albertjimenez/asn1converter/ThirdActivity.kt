package com.cit.albertjimenez.asn1converter

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_third.*
import org.jetbrains.anko.intentFor
import java.util.*

class ThirdActivity : AppCompatActivity() {

    private val imageURL = "http://lorempixel.com/400/200/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        goback.setOnClickListener { startActivity(intentFor<MainActivity>("DATE"
                to GregorianCalendar.getInstance().time.toString())) }
        Glide.with(this).load(imageURL).into(imageViewNet)
                .onLoadStarted(ResourcesCompat.getDrawable(resources, R.drawable.no_internet, null))
        imageViewNet.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up))

    }
}
