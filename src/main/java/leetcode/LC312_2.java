package leetcode;

import java.util.*;

/**
 * 戳气球
 */
class LC312_2 {
    //动态规划
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];//arr[i+1]=nums[i]
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];//dp[i][j]依次计算j-i为1,2，..
        for (int span = 1; span <= n; span++) {
            for (int i1 = 0; i1 + span + 1 < n + 2; i1++) {
                int i2 = i1 + span + 1;
                for (int k = i1 + 1; k < i2; k++) {
                    int fk = dp[i1][k] + dp[k][i2] + arr[i1] * arr[i2] * arr[k];
                    dp[i1][i2] = Math.max(dp[i1][i2], fk);
                }
            }
        }

        //res=dp[0][n+1]
        return dp[0][n + 1];

    }
}



