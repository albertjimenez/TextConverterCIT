package com.cit.albertjimenez.asn1converter.algorithm

import com.cit.albertjimenez.asn1converter.extension.toASCII
import com.cit.albertjimenez.asn1converter.extension.toMorseCode
import com.cit.albertjimenez.asn1converter.extension.toPhoneticCode
import com.cit.albertjimenez.asn1converter.extension.toShorten

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 */

fun textToASCII(text: String): String = text.toASCII()

fun textToPhonetic(text: String): String = text.toPhoneticCode()


fun textToSMS(text: String): String = text.toShorten()

fun textToMorse(text: String): String = text.toMorseCode()
