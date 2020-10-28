package main.java.leetcode;

import java.util.*;

/**
 * 最大矩形
 */
class LC85 {
    //动态规划法，
    //按行遍历求解，每行的状态由上一行确定
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] left = new int[col];
        int[] right = new int[col];
        int[] hight = new int[col];
        Arrays.fill(left, -1);
        Arrays.fill(right, col);

        //遍历行
        for (int i = 0; i < row; i++) {
            //更新left,right,hight
            int curLeft = -1, curRight = col;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    hight[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    //遇到0时的更新规则不同
                    hight[j] = 0;
                    left[j] = -1;
                    curLeft = j;
                }
            }

            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    //遇到0时的更新规则不同
                    right[j] = col;
                    curRight = j;
                }

            }


            //更新面积
            for (int j = 0; j < col; j++) {
                int area = hight[j] * (right[j] - left[j] - 1);
                maxArea = Math.max(maxArea, area);
            }

            // System.out.println("i="+i);
            // System.out.println("left="+Arrays.toString(left));
            // System.out.println("right="+Arrays.toString(right));
            // System.out.println("hight="+Arrays.toString(hight));
            // System.out.println("maxArea="+maxArea);

        }

        return maxArea;
    }
}
