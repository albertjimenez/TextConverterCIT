package com.cit.albertjimenez.asn1converter

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.cit.albertjimenez.asn1converter.algorithm.textToASCII
import com.cit.albertjimenez.asn1converter.algorithm.textToMorse
import com.cit.albertjimenez.asn1converter.algorithm.textToPhonetic
import com.cit.albertjimenez.asn1converter.algorithm.textToSMS
import com.cit.albertjimenez.asn1converter.statistic.StatisticalManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    //Singleton for be used on ThirdActvity, for statistical purposes
    companion object {
        val selectionItems = listOf("Morse", "SMS", "ASCII", "Phonetic")
    }

    private val SHARED_PRF_CONST = listOf("CONVERTED", "INPUTTEXT", "SELECTION")
    private var selection = selectionItems[0]
    private val statsManager = StatisticalManager.instance
    private var sharedPrf :SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set the Adapter for modify how is it going to be showed to user
        spinner.adapter = ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, selectionItems)
        sharedPrf = applicationContext.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        first_button.startAnimation(AnimationUtils.loadAnimation(this, R.anim.move))
        first_edittext.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_down))

        //Lambda for setting the click action
        //Using ANKO of JetBrains, we can have access easily to UI
        first_button.setOnClickListener { startActivity(intentFor<SecondActivity>("INFO" to
                android.os.Build.MODEL)) }

        //Loading statistical data from SharedPreferences
        loadStats()

        statisticButton.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.move))
        statisticButton.setOnClickListener{ startActivity(intentFor<ThirdActivity>()) }

        //Checking third activity launch
        if (intent.hasExtra("DATE")) {

            //Using ANKO DSL we can create programmatically an alert message
            alert(getString(R.string.warning)) {
                title = getString(R.string.information)
                message = getString(R.string.message_back) + "\n" + intent.extras.getString("DATE")
                yesButton { }
            }.show()
        }

        //Object is for singleton access, but in this case, can be used for Anonymous classes
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.d("SPINNER: ", "No item selected")
            }

            //In this case, if you select another option, the previous text will be updated
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selection = selectionItems[p2]
                if (!first_edittext.text.isNullOrBlank())
                    convert(selection, first_edittext.text.toString())
            }
        }

        //Defined an anonymous class for using a TextWatcher, and make
        //Live conversion while you type text
        first_edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val myText = p0!!.toString()
                convert(selection, myText)
                statsManager.addStats(selection)
                saveStatsSharedPrf()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        val convertedText = textView.text.toString()
        val inputText = first_edittext.text.toString()
        val option = selection
        with(outState!!) {
            putString(SHARED_PRF_CONST[0], convertedText)
            putString(SHARED_PRF_CONST[1], inputText)
            putString(SHARED_PRF_CONST[2], option)
        }
        super.onSaveInstanceState(outState)
    }

    //Not necessary to check onCreate if the bundle is null, dedicated method better
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState!!.apply {
            textView.text = getString(SHARED_PRF_CONST[0])
            first_edittext.setText(getString(SHARED_PRF_CONST[1]), TextView.BufferType.EDITABLE)
            selection = getString(SHARED_PRF_CONST[2])
        }
    }


    /**
     * @param selection Represents which conversion you may apply
     *
     * @param data The data will be overwritten with the result
     */
    private fun convert(selection: String, data: String) {
        when (selection) {
            "Morse" -> textView.text = textToMorse(data)
            "SMS" -> textView.text = textToSMS(data)
            "ASCII" -> textView.text = textToASCII(data)
            else -> textView.text = textToPhonetic(data)

        }
    }

    private fun saveStatsSharedPrf() {
        val editor = sharedPrf!!.edit()
        editor.putInt(selection, statsManager.getStats(selection))
        editor.apply()
    }

    private fun loadStats() {
        selectionItems.forEach {
            statsManager.loadStats(it, sharedPrf!!.getInt(it, 0))
        }
    }
}



