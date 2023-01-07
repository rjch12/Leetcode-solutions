/*
 * You are given the head of a linked list. 
 * Delete the middle node, and return the head of the modified linked list.
 * 
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, 
 * where ⌊x⌋ denotes the largest integer less than or equal to x.
 * 
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */
package com.leetcode.problems;

public class DeletetheMiddleNodeofaLinkedList_2095 {
    public static void main(String[] args) {
        DeletetheMiddleNodeofaLinkedList_2095 d = new DeletetheMiddleNodeofaLinkedList_2095();
        ListNode root = new ListNode(2);
        // root.next = new ListNode(1);
        ListNode res = d.deleteMiddle(root);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head, slow = head, prev = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
