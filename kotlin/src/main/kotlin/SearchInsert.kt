package com.dsa.kotlin

fun searchInsert(nums: IntArray, target: Int): Int {
    var min = 0
    var max = nums.size - 1

    while (min <= max) {
        val mid = (min + max) / 2
        val n = nums[mid]
        if (n == target) return mid
        if (n > target) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }

    return min
}

fun main() {
    assertTrue(
        searchInsert(
            intArrayOf(1,3,5,6),
            5
        ),
        2
    )

    assertTrue(
        searchInsert(
            intArrayOf(1,3,5,6),
            2
        ),
        1
    )
}