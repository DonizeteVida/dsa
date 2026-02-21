package com.dsa.kotlin

fun removeElement(nums: IntArray, `val`: Int): Int {
    var pos = 0

    for (i in 0..<nums.size) {
        if (nums[i] != `val`) {
            nums[pos] = nums[i]
            pos++
        }
    }

    return pos
}

fun main() {
    val arr = intArrayOf(3, 2, 2, 3)
    assertTrue(
        removeElement(
            arr,
            3
        ),
        2
    )

    assertTrue(
        arr.take(2),
        listOf(2, 2)
    )
}