package com.cit.albertjimenez.asn1converter.algorithm

import com.cit.albertjimenez.asn1converter.extension.toPhoneticCode
import com.cit.albertjimenez.asn1converter.extension.toShorten
import com.cit.albertjimenez.asn1converter.extension.toASCII

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 */

fun textToASCII(text: String): String {
    return text.toASCII()
}

fun textToPhonetic(text: String): String {
    return text.toPhoneticCode()
}

fun textToSMS(text: String): String {
    return text.toShorten()
}