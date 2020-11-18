package main.java.leetcode;

import java.util.*;

public class sqrt {

    public sqrt() {
    }

    /**
     * 牛顿迭代法, 收敛更快
     */
    public static float sqrt1(int n) {
        float xn = 1, xn1 = 2;
        float eps = 1e-10f;
        while (Math.abs(xn1 - xn) > eps) {
            xn = xn1;
            xn1 = (xn + n / xn) / 2;
        }
        return xn1;
    }

    /**
     * 二分法，精度最大1e-6f.收敛速度没有牛顿迭代法快
     */
    public static float sqrt2(int n) {
        float low = 0, high = n;
        float mid = (low + high) / 2;
        float eps = 1e-6f;
        while (high - low > eps) {
            if (mid * mid > n) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println("sqrt");
        System.out.println(sqrt1(11));
        System.out.println(sqrt2(11));
        System.out.println(Math.sqrt(11));

    }

}
