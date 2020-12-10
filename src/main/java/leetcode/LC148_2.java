package leetcode;

import java.util.*;

/**
 * 排序链表。非最优解，快排算法练习。
 * 注意事项：
 * 1，如果拆分为左中右3个子链，那么左链表可能为空，最终拼接时需要注意。
 * 2，如果拆分为左右2个子链。那么左链表最后需要加上head，这样左链表始终非空，最后拼接时比较容易。
 */
class LC148_2 {

    public ListNode sortList(ListNode head) {
        //空值
        if (head == null || head.next == null) return head;

        //按基准分割为左右子链
        ListNode dummyLeft = new ListNode(0), dummyRight = new ListNode(1);
        ListNode left = dummyLeft, right = dummyRight, cur = head;
        int base = cur.val;
        for (cur = head.next; cur != null; cur = cur.next) {
            if (cur.val < base) {
                left.next = cur;
                left = cur;
            } else {
                right.next = cur;
                right = cur;
            }
        }
        left.next = null;
        right.next = null;

        //递归排序左右子链
        left = sortList(dummyLeft.next);
        right = sortList(dummyRight.next);


        //连接左右子链
        if (left == null) {
            dummyLeft.next = head;
        } else {
            dummyLeft.next = left;
            cur = left;
            while (cur.next != null) cur = cur.next;
            cur.next = head;
        }
        head.next = right;

        return dummyLeft.next;
    }

    private class ListNode {
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
}
