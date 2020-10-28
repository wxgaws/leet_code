package main.java.leetcode;

import java.util.*;

/**
 * 反转链表
 */
class LC206 {
    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h2 = reverseList(head.next);
        ListNode t = head.next;
        t.next = head;
        head.next = null;
        return h2;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
