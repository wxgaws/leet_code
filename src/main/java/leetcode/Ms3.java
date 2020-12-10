package leetcode;

import java.util.*;

public class Ms3 {
    public double maxProduct(double[] arr) {
        int n = arr.length;
        double[] dp1 = new double[n];//max
        double[] dp2 = new double[n];//min
        dp1[0] = arr[0];
        dp2[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = arr[i];
            dp2[i] = arr[i];

            //判断是否与i-1连乘
            dp1[i] = Math.max(dp1[i], dp1[i - 1] * arr[i]);
            dp1[i] = Math.max(dp1[i], dp2[i - 1] * arr[i]);
            dp2[i] = Math.min(dp2[i], dp1[i - 1] * arr[i]);
            dp2[i] = Math.min(dp2[i], dp2[i - 1] * arr[i]);

        }

        double max = -Double.MAX_VALUE;
        for (double c : dp1) max = Math.max(max, c);
        return max;
    }

    public static void main(String[] args) {
        //求连续乘积的最大值，元素可正可负
        Ms3 demo = new Ms3();
        double[] arr1 = {-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.println(demo.maxProduct(arr1));

        double[] arr2 = {-0.1};
        System.out.println(demo.maxProduct(arr2));


    }
}
