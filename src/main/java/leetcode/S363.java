package leetcode;

import java.util.*;

public class S363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int left = 0; left < nCol; left++) {
            int[] rowSum = new int[nRow];
            for (int right = left; right < nCol; right++) {
                //在l和r范围内求矩阵和
                for (int i = 0; i < nRow; i++) {
                    rowSum[i] += matrix[i][right];
                }
                res = Math.max(res, dpmax(rowSum, k));
                if (res == k) return res;
            }
        }

        return res;
    }

    //对一维数据，求子区间不超过 K 的最大数值和
    public int dpmax(int[] a, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        int maxSum = Integer.MIN_VALUE;
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            //在前i-1中查找s[i]-k的插入位置j
            s += a[i];
            int j = bisectLeft(list, s - k, 0, list.size() - 1, false);

            //更新masSum
            if (j >= 0 && j < list.size()) {
                maxSum = Math.max(maxSum, s - list.get(j));
                if (maxSum == k) return maxSum;
            }

            //插入s[i]
            bisectLeft(list, s, 0, list.size() - 1, true);
        }
        return maxSum;

    }

    //在升序list中查找val的插入位置。有重复元素时，返回最小匹配下标。
    //表中插入元素后，外部的表也会改变。
    //start和end均包含
    public static int bisectLeft(LinkedList<Integer> list, int val, int start, int end, Boolean isInsert) {
        if (list.isEmpty()) {
            if (isInsert) list.add(0, val);
            return -1;
        }
        if (start > end || start < 0 || end < 0) {
            System.out.println("**bisectLeft(): error");
            return -1;
        }

        int res = -1;
        if (start == end) {
            if (val <= list.get(start)) {
                res = start;
                if (isInsert) list.add(start, val);
            } else {
                res = start + 1;
                if (isInsert) list.add(start + 1, val);
            }
            return res;
        }

        int mid = (start + end) / 2;
        if (val <= list.get(mid)) {
            res = bisectLeft(list, val, start, mid, isInsert);
        } else {
            res = bisectLeft(list, val, mid + 1, end, isInsert);
        }

        return res;
    }


    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>() {
            {
                add(1);
                add(2);
                add(2);
                add(3);
            }
        };
        System.out.println(list);
        int res = -1;

        for (int val = 0; val < 5; val++) {
            res = bisectLeft(list, val, 0, list.size() - 1, false);
            System.out.println("val=" + val + ", index=" + res);
            System.out.println(list);
        }

    }


}
