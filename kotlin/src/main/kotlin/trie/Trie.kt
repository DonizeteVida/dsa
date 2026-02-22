package com.dsa.kotlin.trie

import com.dsa.kotlin.assertTrue

class Trie {
    private val root = Node('*', false)

    data class Node(
        val char: Char,
        var isWord: Boolean,
        val nodes: MutableMap<Char, Node> = mutableMapOf()
    )

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.nodes.getOrPut(char) {
                Node(char, false)
            }
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (char in word) {
            node = node.nodes[char] ?: return false
        }
        return node.isWord
    }

    fun startsWith(word: String): Boolean {
        var node = root
        for (char in word) {
            node = node.nodes[char] ?: return false
        }
        return true
    }
}

fun main() {
    val t = Trie()
    t.insert("apple")

    assertTrue(
        false,
        t.startsWith("banana")
    )

    assertTrue(
        true,
        t.search("apple")
    )

    assertTrue(
        false,
        t.search("app")
    )

    assertTrue(
        true,
        t.startsWith("app")
    )
}