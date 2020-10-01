package main.java.leetcode;

import java.util.LinkedList;

class S862 {
    public static int shortestSubarray(int[] A, int K) {
        int N = A.length;
        int[] p = new int[N + 1];
        p[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            p[i] = p[i - 1] + A[i - 1];
        }

        LinkedList<Integer> q = new LinkedList<>();
        int res = N + 1;
        for (int j = 0; j < N; j++) {
            if ((q.isEmpty() && p[j + 1] > 0) || (!q.isEmpty() && p[j + 1] > p[q.getLast()])) {
                q.addFirst(j);
            }
            while (!q.isEmpty() && p[j + 1] - p[q.getLast()] >= K) {
                System.out.println("before: Ai=" + q.getLast() + ",  Aj=" + j);
                res = Math.min(res, j + 1 - q.removeLast());
                System.out.println("after:    Ai=" + q.getLast() + ",  Aj=" + j + ", sum=" + (p[j + 1] - p[q.getLast()] - K));
            }
        }

        res = (res < N + 1) ? res : -1;
        return res;
    }

    public static void main(String[] args) {
        int[] A = {-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6};
        int k = 151;
        System.out.println(shortestSubarray(A, k));
    }
}