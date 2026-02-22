package com.dsa.kotlin.tree

import java.util.LinkedList

data class TreeNode(
    val `val`: Int,
    val left: TreeNode? = null,
    val right: TreeNode? = null
)
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

    println(tree)

    val ll = LinkedList<TreeNode>()
    ll.push(tree)

    while (ll.isNotEmpty()) {
        val node = ll.removeFirst()
        println(node.`val`)

        if (node.left != null) ll.add(node.left)
        if (node.right != null) ll.add(node.right)
    }
}