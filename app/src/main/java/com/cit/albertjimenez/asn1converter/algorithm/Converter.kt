package com.cit.albertjimenez.asn1converter.algorithm

import com.cit.albertjimenez.asn1converter.extension.toASCII
import com.cit.albertjimenez.asn1converter.extension.toMorseCode
import com.cit.albertjimenez.asn1converter.extension.toPhoneticCode
import com.cit.albertjimenez.asn1converter.extension.toShorten

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 *
 * The purpose of this class is to encapsulate the Extension function with a friendly method
 */

/**
 * @param text Desired text for being converted
 *
 * @return a new String with ASCII conversion
 */
fun textToASCII(text: String): String = text.toASCII()


/**
 * @param text Desired text for being converted
 *
 * @return a new String with Phonetic conversion
 */
fun textToPhonetic(text: String): String = text.toPhoneticCode()

/**
 * @param text Desired text for being converted
 *
 * @return a new String with SMS conversion
 */
fun textToSMS(text: String): String = text.toShorten()

/**
 * @param text Desired text for being converted
 *
 * @return a new String with Morse code conversion
 */
fun textToMorse(text: String): String = text.toMorseCode()
