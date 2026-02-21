package com.dsa.kotlin

fun <T> assertTrue(expected: T, actual: T) {
    if (expected != actual) {
        throw AssertionError(
            "Expected: $expected, actual: $actual"
        )
    }
}