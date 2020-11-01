package main.java.leetcode;

import java.util.*;

class LC34_2 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) return res;

        res[0] = bisect(nums, target, true);
        res[1] = bisect(nums, target, false);
        return res;
    }

    //二分查找target的最左或最右下标
    //返回值范围是[0,n-1]，无解时返回-1
    public int bisect(int[] nums, int target, boolean left) {
        int res = -1;
        int n = nums.length;
        int low = 0, high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (left && low < n && nums[low] == target) res = low;
        if (!left && low >= 1 && nums[low - 1] == target) res = low - 1;
        return res;
    }
}
