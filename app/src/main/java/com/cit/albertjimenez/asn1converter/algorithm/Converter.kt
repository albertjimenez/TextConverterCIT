package com.cit.albertjimenez.asn1converter.algorithm

import com.cit.albertjimenez.asn1converter.extension.getElemFromInitial
import java.lang.StringBuilder

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 */

private val phoneticList = listOf("alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf",
        "hotel", "india", "juliet", "kilo", "lima", "mike", "november", "oscar", "papa", "quebec",
        "romeo", "sierra", "tango", "uniform", "victor", "whiskey", "x-ray", "yankee", "zulu")

fun textToASCII(text: String): String {
    val stb: StringBuilder = StringBuilder()
    text.toCharArray().forEach {
        stb.append(it.toInt())
        stb.append(" ")
    }
    return stb.toString()
}

fun textToPhonetic(text: String): String {
    val stb: StringBuilder = StringBuilder()
    text.toLowerCase().forEach {
        stb.append(phoneticList.getElemFromInitial(it.toString()))
        stb.append(" ")
    }
    return stb.toString()
}