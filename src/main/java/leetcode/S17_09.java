package main.java.leetcode;

public class S17_09 {
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] arr = new int[k];
            int i3 = 0, i5 = 0, i7 = 0;
            arr[0] = 1;
//            if (k == 1) return arr[0];
            for (int i = 1; i < k; i++) {
                arr[i] = Math.min(arr[i3] * 3, Math.min(arr[i5] * 5, arr[i7] * 7));
                if (arr[i] % 3 == 0) i3++;
                if (arr[i] % 5 == 0) i5++;
                if (arr[i] % 7 == 0) i7++;
            }
            return arr[k - 1];
        }
    }
}
