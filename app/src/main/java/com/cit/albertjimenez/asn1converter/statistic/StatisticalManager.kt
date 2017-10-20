/**
 * Created by Albert Jiménez on 20/10/17 for Programming Mobile Devices.
 */
package com.cit.albertjimenez.asn1converter.statistic

class StatisticalManager private constructor() {

    private var statsMap: HashMap<String, Int> = HashMap()

    private object Holder {
        val INSTANCE = StatisticalManager()
    }

    companion object {
        val instance: StatisticalManager by lazy { Holder.INSTANCE }
    }

    fun addStats(selection: String) {
        if (selection in statsMap)
            statsMap[selection] = statsMap[selection]!!.inc()
        else
            statsMap[selection] = 1

//        if (statsMap.getOrPut(selection, defaultValue = { 1 }) > 1)
//            statsMap[selection] = statsMap[selection]!!.inc()
    }

    fun getStats(selection: String): Int {
        if (selection in statsMap)
            return statsMap[selection]!!
        return 0
    }

    fun loadStats(selection: String, value: Int) {
        statsMap[selection] = value
    }

    override fun toString(): String {
        return statsMap.toString()
    }


}


