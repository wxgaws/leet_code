package leetcode;

import java.util.*;

class LCP18_2 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int count = 0;
        int i = 0, j = drinks.length - 1;
        while (i < staple.length && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                count = (count + j + 1) % 1000000007;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}