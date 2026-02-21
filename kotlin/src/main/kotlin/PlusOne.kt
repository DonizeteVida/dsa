package com.dsa.kotlin

fun plusOne(digits: IntArray): IntArray {
    digits[digits.size - 1] += 1

    var remaining = 0

    for (i in digits.size - 1 downTo 0) {
        val sum = digits[i] + remaining
        if (sum >= 10) {
            digits[i] = 10 - sum
            remaining = 1
        } else {
            digits[i] = sum
            remaining = 0
        }
    }

    if (remaining > 0) {
        val n = IntArray(digits.size + 1)
        n[0] = 1
        return n
    }

    return digits
}

fun main() {
    assertTrue(
        plusOne(
            intArrayOf(9, 9),
        ).toList(),
        listOf(1, 0, 0)
    )

    assertTrue(
        plusOne(
            intArrayOf(5, 9),
        ).toList(),
        listOf(6, 0)
    )
}