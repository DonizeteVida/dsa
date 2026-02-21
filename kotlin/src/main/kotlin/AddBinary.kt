package com.dsa.kotlin

import kotlin.math.max

fun addBinary(a: String, b: String): String {
    val result = StringBuilder()
    var remaining = false

    for (i in 0..<max(a.length, b.length)) {
        val aa = a.getOrElse(a.length - i - 1) { '0' }
        val bb = b.getOrElse(b.length - i - 1) { '0' }

        when {
            aa == '1' && bb == '1' -> {
                result.insert(
                    0,
                    if (remaining) '1' else '0'
                )
                remaining = true
            }
            aa == '0' && bb == '0' -> {
                result.insert(
                    0,
                    if (remaining) '1' else '0'
                )
                remaining = false
            }
            else -> {
                result.insert(
                    0,
                    if (remaining) '0' else '1'
                )
            }
        }
    }

    return if (remaining) {
        "1$result"
    } else {
        result.toString()
    }
}

fun main() {
    assertTrue(
        addBinary(
            "1010",
            "1011"
        ),
        "10101"
    )
}