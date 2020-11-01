package main.java.leetcode;

import java.util.*;


/**
 * 排序链表，归并排序
 */
class LC148 {
    //自底向上归并
    public ListNode sortList(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) len++;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //span循环
        for (int span = 1; span < len; span = span * 2) {
            //span层归并
            ListNode pre = dummy;//合并后的指针

            //i+span>=len时，只有一个span，不用合并
            for (int i = 0; i + span < len; i = i + 2 * span) {
                ListNode p1 = pre.next;
                ListNode p2 = p1;
                for (int j = 0; j < span; j++) p2 = p2.next;//p2=p1+span

                //归并p1和p2
                int i1 = 0, i2 = 0;
                while (i1 < span && i2 < span && p2 != null) {
                    if (p1.val < p2.val) {
                        i1++;
                        pre.next = p1;
                        pre = p1;
                        p1 = p1.next;
                    } else {
                        i2++;
                        pre.next = p2;
                        pre = p2;
                        p2 = p2.next;
                    }

                }

                //连接剩余部分
                while (i1 < span) {
                    i1++;
                    pre.next = p1;
                    pre = p1;
                    p1 = p1.next;
                }

                while (i2 < span && p2 != null) {
                    i2++;
                    pre.next = p2;
                    pre = p2;
                    p2 = p2.next;
                }

                pre.next = p2;

            }


        }

        return dummy.next;
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
