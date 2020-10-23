package main.java.leetcode;

import java.util.*;

/**
 * 三数之和
 */
class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int ai = 0; ai < nums.length; ai++) {
            //不同于上次
            if (ai > 0 && nums[ai] == nums[ai - 1]) {
                continue;
            }

            for (int bi = ai + 1, ci = nums.length - 1; bi < ci; ) {
                //不同于上次, 所以bi > ai + 1，而不是bi>0
                if (bi > ai + 1 && nums[bi] == nums[bi - 1]) {
                    bi++;
                    continue;
                }

                int sum = nums[ai] + nums[bi] + nums[ci];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[ai]);
                    list.add(nums[bi]);
                    list.add(nums[ci]);
                    res.add(list);
                    bi++;
                    // System.out.println("list="+list);
                } else if (sum > 0) {
                    ci--;
                } else {
                    bi++;
                }
            }
        }

        return res;
    }
}




