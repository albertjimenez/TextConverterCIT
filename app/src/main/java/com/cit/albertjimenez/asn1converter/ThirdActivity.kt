package com.cit.albertjimenez.asn1converter

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cit.albertjimenez.asn1converter.statistic.StatisticalManager
import kotlinx.android.synthetic.main.activity_third.*
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel
import org.jetbrains.anko.intentFor
import java.util.*


class ThirdActivity : AppCompatActivity() {

    private val imageURL = "https://source.unsplash.com/random/400x400"
    private val selectionItems = MainActivity.selectionItems
    private val statsManager = StatisticalManager.instance
    private val colorList = listOf(Color.parseColor("#FE6DA8"),
            Color.parseColor("#56B7F1"), Color.parseColor("#CDA67F"),
            Color.parseColor("#FED70E"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val openingTime = GregorianCalendar.getInstance().time.toString()
        goback.setOnClickListener {
            startActivity(intentFor<MainActivity>("DATE"
                    to openingTime))
        }
        loadPieChart(piechart)
        piechart.innerValueColor = Color.parseColor("#000000")
        piechart.startAnimation()

    }

    fun loadPieChart(pieChart: PieChart) {
        var count = 0
        selectionItems.forEach {
            pieChart.addPieSlice(PieModel(it, statsManager.getStats(it).toFloat(), colorList[count]))
            count += 1
        }

    }
}
