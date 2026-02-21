package com.dsa.kotlin


fun lengthOfLastWord(s: String): Int {
    var prev = ' '

    var start = 0
    var end = 0

    for (i in 0..<s.length) {
        val current = s[i]

        if (prev == ' ' && current != ' ') {
            start = i
            end = s.length
        } else if (prev != ' ' && current == ' ') {
            end = i
        }

        prev = current
    }

    return end - start
}

fun main() {
    assertTrue(
        lengthOfLastWord("Hello World"),
        5
    )

    assertTrue(
        lengthOfLastWord("   fly me   to   the moon  "),
        4
    )
}