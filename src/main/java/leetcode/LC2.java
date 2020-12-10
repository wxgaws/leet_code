package leetcode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 */
//两数相加，自定义链表
class LC2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur1 = l1, cur2 = l2, p = head;
        int carray = 0;
        while (cur1 != null || cur2 != null) {
            int v1 = (cur1 != null) ? cur1.val : 0;
            int v2 = (cur2 != null) ? cur2.val : 0;
            int v = (v1 + v2 + carray) % 10;
            carray = (v1 + v2 + carray) / 10;
            ListNode node = new ListNode(v);
            p.next = node;
            // System.out.printf("v=%d, carray%d\n",v,carray);

            p = node;
            cur1 = (cur1 != null) ? cur1.next : null;
            cur2 = (cur2 != null) ? cur2.next : null;
        }
        if (carray > 0) {
            ListNode node = new ListNode(carray);
            p.next = node;
        }

        return head.next;
    }
}