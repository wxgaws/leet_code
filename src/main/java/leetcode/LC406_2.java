package leetcode;

import java.util.*;

class LC406_2 {
    public int[][] reconstructQueue(int[][] people) {
        //用lambda表达式排序
        Arrays.sort(people, (a1, a2) -> {
            //0降序，1升序
            int res = (a1[0] == a2[0]) ? (a1[1] - a2[1]) : (a2[0] - a1[0]);
            return res;
        });

        List<int[]> list = new ArrayList<>();
        for (int[] pair : people) {
            list.add(pair[1], pair);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
