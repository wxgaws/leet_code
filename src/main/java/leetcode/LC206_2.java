package leetcode;

import java.util.*;

/**
 * 反转链表
 */
class LC206_2 {
    //循环
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
