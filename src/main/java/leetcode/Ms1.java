package leetcode;

import java.util.*;

public class Ms1 {
    /**
     * 问题：求数组arr[]的所有子串
     * 思路：用递归的方式求解.
     * 解法：
     * 1，将数组arr的n个元素，拆违a0和剩余n-1个元素arrN1
     * 2，arr的所有子串，包括三部分：a0, arrN1的所有子串，a1和arrN1的所有子串的交叉
     * 3,对重复的子串要去重，用set，或者在加入list时判断是否存在。
     */
    public static Set<List<Integer>> subArr(int[] arr) {
        Set<List<Integer>> res = new LinkedHashSet<>();

        if (arr.length == 1) {
            res.add(new ArrayList<>());
            res.add(new ArrayList<>(Arrays.asList(arr[0])));
            return res;
        }

        //1
        res.add(new ArrayList<>(Arrays.asList(arr[0])));

        //n-1
        int[] arrN1 = Arrays.copyOfRange(arr, 1, arr.length);
        Set<List<Integer>> resN1 = subArr(arrN1);
        res.addAll(resN1);

        //1,{n-1} cross
        for (List<Integer> list : resN1) {
            List<Integer> list2 = new ArrayList<>();
            list2.add(arr[0]);
            list2.addAll(list);
            res.add(list2);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Ms1");

        int[] arr = {1, 2, 3};
        Set<List<Integer>> res = subArr(arr);
        for (List<Integer> list : res) {
            System.out.println(list);
        }

    }

}