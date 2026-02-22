package com.dsa.kotlin.tree.exercises

import com.dsa.kotlin.assertTrue
import com.dsa.kotlin.tree.TreeNode

fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    return inorderTraversal(root.left) +
            listOf(root.`val`) +
            inorderTraversal(root.right)
}

/**
 *         1
 *        / \
 *       2   3
 *      / \ / \
 *     4  5 6  7
 */
fun main() {
    val tree = TreeNode(
        1,
        TreeNode(
            2,
            TreeNode(4),
            TreeNode(5)
        ),
        TreeNode(
            3,
            TreeNode(6),
            TreeNode(7),
        ),
    )

    assertTrue(
        listOf(4, 2, 5, 1, 6, 3, 7),
        inorderTraversal(tree)
    )
}