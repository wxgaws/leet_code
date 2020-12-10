package leetcode;

import java.util.*;

/**
 * 根据身高重建队列
 */
class LC406 {
    //排序和链表
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                //0维降序，1维升序
                int res = (a1[0] == a2[0]) ? (a1[1] - a2[1]) : (a2[0] - a1[0]);
                return res;
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] pair : people) {
            list.add(pair[1], pair);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
