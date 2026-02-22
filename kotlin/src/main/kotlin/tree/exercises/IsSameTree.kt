package com.dsa.kotlin.tree.exercises

import com.dsa.kotlin.assertTrue
import com.dsa.kotlin.tree.TreeNode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` != q.`val`) return false
    return isSameTree(
        p.left,
        q.left
    ) && isSameTree(
        p.right,
        q.right
    )
}

fun main() {
    run {
        val a = TreeNode(1, left = TreeNode(2))
        val b = TreeNode(1, right = TreeNode(2))

        assertTrue(isSameTree(a, b), false)
    }

    run {
        val a = TreeNode(1, left = TreeNode(2))
        val b = TreeNode(1, left = TreeNode(2))

        assertTrue(isSameTree(a, b), true)
    }
}