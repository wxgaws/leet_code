package main.java.leetcode;

import java.util.*;

/**
 * 戳气球
 */
class LC312 {
    //递归
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int max = maxF(arr, 0, n + 1);
        return max;
    }

    public int maxF(int[] arr, int i1, int i2) {
        int max = 0;
        for (int k = i1 + 1; k < i2; k++) {
            int cur = maxF(arr, i1, k) + maxF(arr, k, i2) + arr[i1] * arr[i2] * arr[k];
            max = Math.max(cur, max);
        }
        return max;
    }

}
