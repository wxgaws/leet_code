package main.java.leetcode;

import java.util.*;

public class KS1 {
    /**
     * 判断arr元素正负号求和后是否可为sum，并返回各元素正负号
     */
    public static boolean sumEq(int[] arr, int sum, int[] sign) {
        int sum1 = 0;
        for (int a : arr) {
            sum1 += a;
        }
        sum1 += sum;
        if (sum1 % 2 == 1) return false;
        sum1 = sum1 / 2;

        int[] visited = new int[arr.length];//1/0是否解的一部分
        int flag = exist(arr, sum1, 0, visited);
        if (flag == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i] == 1) {
                    sign[i] = 1;//正号
                } else {
                    sign[i] = -1;//负号
                }
            }

            return true;
        }

        return false;
    }

    /**
     * 从下标k开始的数组，是否存在和为sum的子序列
     * return: 0不存在，1存在
     */
    public static int exist(int[] arr, int sum, int k, int[] visited) {
        int flag = 0;
        int n = arr.length;

        //exit condition
        if (k >= n) return 0;
        if (k < n && sum == arr[k]) {
            visited[k] = 1;
            return 1;
        }


        //iter
        visited[k] = 1;
        int flag2 = exist(arr, sum - arr[k], k + 1, visited);
        if (flag2 == 1) {
            return 1;
        } else {
            visited[k] = 0;
            return exist(arr, sum, k + 1, visited);
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 4};
        int sum = 5;
        int[] sign = new int[arr.length];
        boolean flag = sumEq(arr, sum, sign);
        System.out.println("arr=" + Arrays.toString(arr) + ", sum=" + sum);
        System.out.println(flag);
        System.out.println("sign=" + Arrays.toString(sign));
    }
}
