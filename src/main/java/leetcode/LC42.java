package leetcode;

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
            //比栈顶元素大，说明栈顶可以存水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int rain = (Math.min(height[i], height[left]) - height[top]) * (i - left - 1);
                sum += rain;
            }

            //栈中已存元素时递减的
            stack.push(i);
        }

        return sum;
    }
}
