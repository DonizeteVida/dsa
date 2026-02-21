package com.dsa.kotlin

fun romanToInteger(s: String): Int {
    var sum = 0
    var last = 0

    for (i in s.length - 1 downTo 0) {
        val value = when (s[i]) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> throw IllegalStateException("Not valid roman number: ${s[i]}")
        }

        if (value < last) {
            sum -= value
        } else {
            sum += value
        }

        last = value
    }

    return sum
}

fun main() {
    assert(romanToInteger("III") == 3)
    assert(romanToInteger("IV") == 3)
    assert(romanToInteger("XX") == 20)
    assert(romanToInteger("MIV") == 1004)
}