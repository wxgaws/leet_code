package main.java.leetcode;

import java.util.*;

/**
 * 接雨水问题
 */
class LC42 {
    //用stack
    public int trap(int[] height) {
        int sum = 0;//当前雨水量
        Stack<Integer> stack = new Stack<>();//保存index
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int rain = (Math.min(height[i], height[left]) - height[top]) * (i - left - 1);
                // System.out.printf("left=%d, top=%d, i=%d, rain=%d\n",left,top,i,rain);
                sum += rain;
            }

            stack.push(i);
            // System.out.printf("i=%d, sum=%d, stack=%s\n",i,sum, stack.toString());


        }

        return sum;
    }
}
