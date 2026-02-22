package com.dsa.kotlin

import kotlin.math.max

fun lengthOfLongestSubstring(s: String): Int {
    val seen = mutableSetOf<Char>()
    var l = 0
    var longest = 0

    for (r in 0..<s.length) {
        while (s[r] in seen) {
            seen -= s[l]
            l++
        }

        seen += s[r]
        longest = max(longest, r - l + 1)
    }

    return longest
}

fun main() {
    assertTrue(
        lengthOfLongestSubstring("pwwkew"),
        3
    )
}