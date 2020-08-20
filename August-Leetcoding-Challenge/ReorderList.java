/*
* Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
* You may not modify the values in the list's nodes, only nodes itself may be changed.
* Example 1: Given 1->2->3->4, reorder it to 1->4->2->3.
* Example 2: Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
* */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slowNode = head, fastNode = head, mid = null;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        mid = slowNode;
        mid.next = reverse(mid.next);
        ListNode node = head, nextNode = node.next;
        while (mid != null && mid.next != null) {
            node.next = mid.next;
            mid.next = mid.next.next;
            node.next.next = nextNode;
            node = nextNode;
            nextNode = node.next;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, current = node, next = current;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
