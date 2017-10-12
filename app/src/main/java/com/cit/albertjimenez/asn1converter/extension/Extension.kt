package com.cit.albertjimenez.asn1converter.extension

/**
 * Created by Albert Jiménez on 12/10/17 for Programming Mobile Devices.
 */

/**
 * @param string which we like to know if the initial is on a list
 *
 * @return empty string if there is no result, or the String associated
 */
fun List<String>.getElemFromInitial(string: String): String {
    var elem = ""
    forEach {
        if (it.toLowerCase()[0] == string.toLowerCase()[0])
            elem = it.toLowerCase()
    }
    return elem
}