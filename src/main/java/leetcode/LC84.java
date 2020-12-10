package leetcode;

import java.util.*;

/**
 * 柱状图中的最大矩阵
 */
class LC84 {
    //用单调栈实现
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] heights2 = Arrays.copyOf(heights, heights.length + 1);
        Stack<Integer> stack = new Stack<>();//index栈,对应元素递增a0<=a1<=a2
        for (int i = 0; i < heights2.length; i++) {
            while (!stack.isEmpty() && heights2[i] < heights2[stack.peek()]) {
                int top = stack.pop();
                int right = i;
                int left = (!stack.isEmpty()) ? stack.peek() : -1;
                int area = heights2[top] * (right - left - 1);
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
