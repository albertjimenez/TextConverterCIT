package com.cit.albertjimenez.asn1converter.extension

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 */

/**
 * @param string which we like to know if the initial is on a list
 *
 * @return empty string if there is no result, or the String associated
 */
private val phoneticList = listOf("alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf",
        "hotel", "india", "juliet", "kilo", "lima", "mike", "november", "oscar", "papa", "quebec",
        "romeo", "sierra", "tango", "uniform", "victor", "whiskey", "x-ray", "yankee", "zulu")

fun String.getPhoneticCode(): String {
    var elem = ""
    forEach {
        val myChar = it.toString()
        phoneticList.forEach {
            if (it.toLowerCase()[0] == myChar.toLowerCase()[0])
                elem += it.toLowerCase() + " "
        }
    }
    return elem
}