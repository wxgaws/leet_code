package main.java.leetcode;

import java.util.*;

class S862 {
    class Solution {
        public int shortestSubarray(int[] A, int K) {
            int N = A.length;
            int[] s = new int[N + 1];
            s[0] = 0;
            for (int i = 0; i < N; i++) {
                s[i + 1] = s[i] + A[i];
            }

            Deque<Integer> que = new LinkedList();
            int span = N + 1;
            for (int j = 0; j < s.length; j++) {
                //保证队单调
                while (!que.isEmpty() && s[que.getLast()] >= s[j]) {
                    que.removeLast();
                }
                //更新span
                while (!que.isEmpty() && s[j] - s[que.getFirst()] >= K) {
                    span = Math.min(span, j - que.removeFirst());
                }
                //提前退出
                if (span == 1) return 1;
                que.addLast(j);
            }
            span = (span == N + 1) ? -1 : span;
            return span;
        }
    }
}