package com.dsa.kotlin

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var a = m - 1
    var b = n - 1
    var c = (m + n) - 1

    while (b >= 0) {
        nums1[c--] = if (a >= 0 && nums1[a] > nums2[b])
            nums1[a--]
        else
            nums2[b--]
    }
}

fun main() {
    run {
        val arr = intArrayOf(10, 0, 0, 0, 0)
        merge(
            arr,
            1,
            intArrayOf(1, 2, 3, 4),
            4
        )
        assertTrue(
            arr.toList(),
            listOf(1, 2, 3, 4, 10)
        )
    }
    run {
        val arr = intArrayOf(1, 0)
        merge(
            arr,
            1,
            intArrayOf(2),
            1
        )
        assertTrue(
            arr.toList(),
            listOf(1, 2)
        )
    }
    run {
        val arr = intArrayOf(1, 2, 3, 0, 0, 0)
        merge(
            arr,
            3,
            intArrayOf(4, 5, 6),
            3
        )
        assertTrue(
            arr.toList(),
            listOf(1, 2, 3, 4, 5, 6)
        )
    }

    run {
        val arr = intArrayOf(4, 5, 6, 0, 0, 0)
        merge(
            arr,
            3,
            intArrayOf(1, 2, 3),
            3
        )
        assertTrue(
            arr.toList(),
            listOf(1, 2, 3, 4, 5, 6)
        )
    }
}