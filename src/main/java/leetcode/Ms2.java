package main.java.leetcode;

import java.util.*;


public class Ms2 {

    public Ms2() {
    }

    public static int methodN(int m, int n, int k) {
        int[] count = new int[m];
        Arrays.fill(count, 1);
        int[] sum = new int[1];
        boolean flag = method(m, n, k, 0, count, sum);
        return sum[0];

    }

    //dfs
    public static boolean method(int m, int n, int k, int mi, int[] count, int[] sum) {
//        System.out.printf("m=%d, n=%d, mi=%d, count=%s, sum=%d\n", m, n, mi, Arrays.toString(count), sum[0]);
        if (m == 0 && n == 0) {
            int mul = 1;
            for (int c : count) {
                mul *= c;
            }
            sum[0] += mul;
            return true;
        }
        if (m <= 0 || n <= 0) return false;

        boolean flag2 = false;
        for (int i = 1; i <= k; i++) {
            count[mi] = cnk(n, i);//第mi辆车选人的方法数
            boolean flag = method(m - 1, n - i, k, mi + 1, count, sum);
            if (flag) {
                flag2 = true;
            }
        }
        return flag2;
    }

    //组合数
    public static int cnk(int n, int k) {
        int res = 1;
        res = pk(n) / (pk(k) * pk(n - k));
        return res;
    }

    public static int pk(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(pk(3));
//        System.out.println(cnk(5, 2));
        System.out.println(methodN(3, 5, 3));
        System.out.println(methodN(2, 3, 2));
        System.out.println(methodN(2, 2, 1));
    }

}
