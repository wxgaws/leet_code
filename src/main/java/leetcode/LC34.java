package main.java.leetcode;

import java.util.*;

class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = bisect(nums, target, true);
        if (left >= nums.length || nums[left] != target) return res;
        res[0] = left;
        res[1] = bisect(nums, target, false) - 1;
        return res;
    }

    /**
     * 二分查找target的最左或最右插入位置
     * 返回值范围是[0,n]
     * 1, left=true时，返回结果满足nums[res]>=target, 有相等的情况。因此查找相等时，应该看最左边插入位置。
     * 2, left=false时，返回结果满足res=n或者nums[res]>target。
     */
    public int bisect(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}



