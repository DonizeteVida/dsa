package com.dsa.kotlin

data class ListNode(
    var `val`: Int,
    var next: ListNode? = null
)

fun deleteDuplicates(head: ListNode?): ListNode? {
    var cur = head
    while (cur != null) {
        if (cur.`val` == cur.next?.`val`) {
            cur.next = cur.next?.next
        } else {
            cur = cur.next
        }
    }
    return head
}

fun main() {
    assertTrue(
        deleteDuplicates(
            ListNode(
                1,
                ListNode(
                    1,
                    ListNode(2)
                ),
            )
        ),
        ListNode(
            1,
            ListNode(2)
        )
    )
}