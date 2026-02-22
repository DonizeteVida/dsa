package com.dsa.kotlin.fibonacci

import com.dsa.kotlin.assertTrue
import kotlin.time.measureTime

fun fibonacciV1(n: Int): Int {
    if (n <= 1) return n
    return fibonacciV1(n - 1) + fibonacciV1(n - 2)
}

fun fibonacciV2(n: Int, memo: MutableMap<Int, Int> = mutableMapOf()): Int {
    if (n <= 1)
        return n

    return memo.getOrPut(n) {
        fibonacciV2(n - 1, memo) + fibonacciV2(n - 2, memo)
    }
}

fun fibonacciV3(n: Int): Int {
    var a = 0
    var b = 1

    for (i in 0..<n) {
        val n = a + b
        a = b
        b = n
    }

    return a
}

fun main() {
    measureTime {
        assertTrue(
            listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377),
            List(15, ::fibonacciV1)
        )
    }.also(::println)

    measureTime {
        assertTrue(
            listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377),
            List(15, ::fibonacciV2)
        )
    }.also(::println)

    measureTime {
        assertTrue(
            listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377),
            List(15, ::fibonacciV3)
        )
    }.also(::println)
}