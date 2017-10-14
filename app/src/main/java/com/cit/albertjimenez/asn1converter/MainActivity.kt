package com.cit.albertjimenez.asn1converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.cit.albertjimenez.asn1converter.algorithm.textToASCII
import com.cit.albertjimenez.asn1converter.algorithm.textToMorse
import com.cit.albertjimenez.asn1converter.algorithm.textToPhonetic
import com.cit.albertjimenez.asn1converter.algorithm.textToSMS
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    private val selectionItems = listOf("Morse", "SMS", "ASCII", "Phonetic")
    var selection = selectionItems[0]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner.adapter = ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, selectionItems)


        first_button.setOnClickListener { startActivity(intentFor<SecondActivity>()) }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.d("SPINNER: ", "No item selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selection = selectionItems[p2]
                if (!first_edittext.text.isNullOrBlank()){
                    val myText = first_edittext.text.toString()
                    when (selection) {
                        "Morse" -> textView.text = textToMorse(myText)
                        "SMS" -> textView.text = textToSMS(myText)
                        "ASCII" -> textView.text = textToASCII(myText)
                        else -> textView.text = textToPhonetic(myText)

                    }
                }
            }
        }

        first_edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val myText = p0!!.toString()
                when (selection) {
                    "Morse" -> textView.text = textToMorse(myText)
                    "SMS" -> textView.text = textToSMS(myText)
                    "ASCII" -> textView.text = textToASCII(myText)
                    else -> textView.text = textToPhonetic(myText)

                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

}


