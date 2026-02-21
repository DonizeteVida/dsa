package com.dsa.kotlin

fun findFirstOccurrence(haystack: String, needle: String): Int {
    var pos = 0

    o@ while (pos <= (haystack.length - needle.length)) {
        if (haystack[pos] != needle.first()) {
            pos++
            continue
        }

        for (i in 0..<needle.length) {
            if (haystack[pos + i] != needle[i]) {
                pos++
                continue@o
            }
        }

        return pos
    }

    return -1
}

fun main() {
    assertTrue(
        findFirstOccurrence(
            "sadbutsad",
            "sad"
        ),
        0
    )

    assertTrue(
        findFirstOccurrence(
            "a",
            "a"
        ),
        0
    )
}