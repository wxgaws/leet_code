package main.java.leetcode;

import java.util.*;

/**
 * 最大正方形
 */
class LC221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int maxArea = 0, maxLen = 0;
        int row = matrix.length, col = matrix[0].length;
        //dp(i,j)以ij为右下点的最大正方形边长
        //dp(i,j)=min(left,up,left_up)+1
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                }
                maxLen = Math.max(maxLen, dp[i][j]);
                // System.out.printf("i=%d, j=%d, matrix=%s, dp=%d, maxLen=%d\n",i,j,matrix[i][j],dp[i][j], maxLen);
            }
        }

        maxArea = maxLen * maxLen;
        return maxArea;
    }
}
