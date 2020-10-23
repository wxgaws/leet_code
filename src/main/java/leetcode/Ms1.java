package main.java.leetcode;

import java.util.*;

public class Ms1 {

    public Ms1() {
    }

    public static List<List<Integer>> subArr(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        if (arr.length == 1) {
            res.add(new ArrayList<>());
            res.add(new ArrayList<>(Arrays.asList(arr[0])));
            return res;
        }

        //1
        res.add(new ArrayList<>(Arrays.asList(arr[0])));

        //n-1
        int[] arrN1 = new int[arr.length - 1];
        for (int i = 0; i < arrN1.length; i++) {
            arrN1[i] = arr[i + 1];
        }
        List<List<Integer>> resN1 = subArr(arrN1);
        for (List<Integer> list : resN1) {
            if (!res.contains(list)) res.add(list);

            //1,{n-1} cross
            List<Integer> list2 = new ArrayList<>();
            list2.addAll(list);
            list2.add(arr[0]);
            if (!res.contains(list2)) res.add(list2);

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Ms1");

        int[] arr = {1, 2, 3};
        List<List<Integer>> res = subArr(arr);
        for (List<Integer> list : res) {
            System.out.println(list);
        }

    }

}