package main.java.leetcode;

import java.util.*;

class LC42_2 {
    //双指针，当前列能存的水量取决于左右两侧最高点中最低的
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int rainSum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        maxRight[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        // System.out.println(Arrays.toString(maxLeft));
        // System.out.println(Arrays.toString(maxRight));

        for (int i = 0; i < height.length; i++) {
            int wall = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < wall) {
                rainSum = rainSum + wall - height[i];
            }
            // System.out.printf("i=%d, height=%d, wall=%d, rainSum=%d \n",i,height[i], wall, rainSum);
        }

        return rainSum;
    }
}






