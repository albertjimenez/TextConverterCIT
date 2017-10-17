package com.cit.albertjimenez.asn1converter.extension

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 */


private val phoneticList by lazyOf(listOf("alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf",
        "hotel", "india", "juliet", "kilo", "lima", "mike", "november", "oscar", "papa", "quebec",
        "romeo", "sierra", "tango", "uniform", "victor", "whiskey", "x-ray", "yankee", "zulu"))
private val phoneticNumberList by lazyOf(listOf("zero", "one", "two", "three", "four", "five", "six",
        "seven", "eight", "nine"))
private val dictSMS by lazyOf(mapOf("post script" to "P.S.", "as soon as posible" to "A.S.A.P", "you" to "U",
        "because" to "BC", "see" to "C", "estimated time of arrival" to "E.T.A.", "do it yourself" to "D.I.Y",
        "to be honest" to "tbh", "thought" to "tho", "road" to "rd", "avenue" to "Ave", "for example" to "e.g."))

private val alphabet by lazyOf(listOf("a", "b", "c", "d", "e", "f", "g", "h", "i",
        "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
        "v", "w", "x", "y", "z", " "))

private val morse by lazyOf(listOf(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--..", "|"))

/**
 * Extension method for converting the String itself to a Phonetic Code
 * @return a new string with the conversion
 */
fun String.toPhoneticCode(): String {
    var elem = ""
    forEach {
        val myChar = it.toString()
        val myRealChar = it
        if (myRealChar.isDigit())
            elem += phoneticNumberList[Integer.parseInt(myChar)] + " "
        else
            phoneticList.forEach {
                if (it.toLowerCase()[0] == myChar.toLowerCase()[0])
                    elem += it.toLowerCase() + " "
            }
    }
    return elem
}

/**
 * Extension method for converting the String to a Morse Code
 *
 * @return a new string with the conversion
 */
fun String.toMorseCode(): String {
    val stb = StringBuilder()
    this.toLowerCase().forEach {
        if (it.toString() == " ") stb.append(" ")
        val result = if (it.toString() in alphabet) morse[alphabet.indexOf(it.toString())] else "?"
        stb.append(result)
    }
    return stb.toString()
}

/**
 * Extension method for converting the String to a SMS Code
 *
 * @return a new string with the conversion
 */
fun String.toShorten(): String {
    val splittedArray = this.split(" ")
    val stb = StringBuilder()
    splittedArray.forEach {
        val result = if (it.toLowerCase() in dictSMS) dictSMS[it.toLowerCase()] + " " else it + " "
        stb.append(result)
    }
    return stb.toString()
}

/**
 * Extension method for converting the String to an ASCII Code
 *
 * @return a new string with the conversion
 */
fun String.toASCII(): String {
    val stb = StringBuilder()
    this.toCharArray().forEach {
        stb.append(Integer.toHexString(it.toInt()) + " ")
    }
    return stb.toString()
}