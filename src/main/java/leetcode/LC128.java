package main.java.leetcode;

import java.util.*;

/**
 * 最长连续序列
 */
class LC128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Long> set = new HashSet<>();
        for (long a : nums) {
            set.add(a);
        }
        for (long a : set) {
            //判断是否序列最小值
            if (set.contains(a - 1)) continue;

            //累加确定序列长度
            int curLen = 1;
            long a1 = a + 1;
            while (set.contains(a1)) {
                a1++;
                curLen++;
            }
            max = Math.max(max, curLen);
        }

        return max;
    }
}
