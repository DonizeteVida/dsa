package com.dsa.kotlin

fun myAtoi(s: String): Int {
    var started = false
    var signal = 1
    var result = 0

    for (c in s) {
        if (c == ' ') continue
        if (c == '-') {
            if (started) return 0
            signal = -1
            started = true
            continue
        }
        if (c < '0' || c > '9') break;
        result *= 10
        result += -('0' - c)
        started = true
    }

    return result * signal
}

fun main() {
    assertTrue(
        -91283472332,
        myAtoi("-91283472332")
    )
}