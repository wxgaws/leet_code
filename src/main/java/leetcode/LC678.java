package main.java.leetcode;

import java.util.*;

/**
 * 有效的括号字符串
 */
public class LC678 {

    //计算未匹配左括号的最大值和最小值
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;//未匹配左括号的最大值和最小值
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(i, i + 1);
            if (cur.equals("(")) {
                leftMin++;
                leftMax++;
            } else if (cur.equals(")")) {
                if (leftMin > 0) leftMin--; //leftMin最小为0
                if (leftMax > 0) {
                    leftMax--;
                } else {
                    return false; //leftMax为0，说明没有左括号可以抵消了
                }

            } else {
                if (leftMin > 0) leftMin--;
                leftMax++;
            }

            // System.out.printf("i=%d, cur=%s, min=%d, max=%d\n",i, cur, leftMin, leftMax);

        }

        return leftMin == 0;

    }

    public static void main(String[] args) {

    }

}
