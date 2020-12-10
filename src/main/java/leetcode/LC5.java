package leetcode;

/**
 * 5. 最长回文子串
 */
class LC5 {
    //中心扩展，时间复杂度n^2
    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        int n = s.length();
        //以i为中心，向两侧扩展。
        //回文有奇数和偶数两种
        int i = 0;
        while (i <= n - 1) {
            int left = -1, right = -1;
            String res1 = "", res2 = "";

            //奇数回文
            left = i;
            right = i;
            res1 = search(s, left, right);

            //偶数回文
            if (i <= n - 2 && s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;
                res2 = search(s, left, right);
            }

            String resTmp = (res1.length() > res2.length()) ? res1 : res2;
            if (resTmp.length() > max) {
                max = resTmp.length();
                res = resTmp;
            }

            i++;
        }

        return res;
    }

    public String search(String s, int left, int right) {
        String res = "";
        int n = s.length();
        while (s.charAt(left) == s.charAt(right)) {
            res = s.substring(left, right + 1);
            if (left >= 1 && right <= n - 2) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return res;
    }
}