package com.cit.albertjimenez.asn1converter.algorithm

import com.cit.albertjimenez.asn1converter.extension.getPhoneticCode
import java.lang.StringBuilder

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 */



fun textToASCII(text: String): String {
    val stb: StringBuilder = StringBuilder()
    text.toCharArray().forEach {
        stb.append(it.toInt())
        stb.append(" ")
    }
    return stb.toString()
}

fun textToPhonetic(text: String): String {
    return text.getPhoneticCode()
}