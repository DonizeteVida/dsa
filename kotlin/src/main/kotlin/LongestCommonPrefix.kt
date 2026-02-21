package com.dsa.kotlin

import kotlin.math.min

fun longestCommonPrefix(vararg strs: String): String {
    var prev = strs[0]

    for (i in 1..<strs.size) {
        val current = strs[i]

        var pos = 0
        val max = min(prev.length, current.length)

        while (pos < max && current[pos] == prev[pos]) {
            pos++
        }

        prev = current.substring(0, pos)
    }

    return prev
}

fun main() {
    assert(
        longestCommonPrefix(
            "flower", "flow", "flight"
        ) == "fl"
    )
}