package leetcode;

import java.util.*;

/**
 * 4. 寻找两个正序数组的中位数
 * 二分法查找有序数组的第k个小的数
 */
class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = (n1 + n2 + 1) / 2;
        int right = (n1 + n2 + 2) / 2;
        double res = getKth(nums1, 0, n1 - 1, nums2, 0, n2 - 1, left);
        res += getKth(nums1, 0, n1 - 1, nums2, 0, n2 - 1, right);
        res = res * 0.5;
        return res;
    }

    //二分查找
    public double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);

        //退出条件
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        //折半迭代
        int i1 = start1 + Math.min(len1, k / 2) - 1;
        int i2 = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i1] < nums2[i2]) {
            return getKth(nums1, i1 + 1, end1, nums2, start2, end2, k - (i1 - start1 + 1));
        } else {
            return getKth(nums1, start1, end1, nums2, i2 + 1, end2, k - (i2 - start2 + 1));
        }

    }

}