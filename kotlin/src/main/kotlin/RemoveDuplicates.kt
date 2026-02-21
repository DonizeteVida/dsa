package com.dsa.kotlin

fun removeDuplicates(nums: IntArray): Int {
    var prev = nums[0]
    var pos = 1

    for (i in 1..<nums.size) {
        val current = nums[i]
        if (current != prev) {
            nums[pos] = current
            prev = current
            pos++
        }
    }

    return pos
}

fun main() {
    val nums = intArrayOf(
        0, 0, 1, 1, 1, 2, 2, 3, 3, 4
    )
    assertTrue(
        removeDuplicates(nums),
        5
    )

    assertTrue(
        nums.take(5), listOf(
            0, 1, 2, 3, 4
        )
    )
}