package leetcode;

import java.util.*;

/**
 * 有效的括号字符串
 */
class LC678_2 {
    //计算未匹配左括号的最大值和最小值
    //使用char
    public boolean checkValidString(String s) {
        int min = 0, max = 0;//未匹配左括号的最大值和最小值
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (min > 0) min--;
                if (max-- == 0) return false;
            } else {
                if (min > 0) min--;
                max++;
            }
        }

        return min == 0;

    }
}