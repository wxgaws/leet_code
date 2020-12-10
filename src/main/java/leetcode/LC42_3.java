package leetcode;

import java.util.*;

/**
 * 一维接雨水，围栏+优先队列
 */
class LC42_3 {
    //左右围栏
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int rainSum = 0;
        int n = height.length;
        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> {
            return a1[1] - a2[1];
        });//围栏(x,h,dir),其中dir=-1为左边界，dir=1为从右边界
        int[] visited = new int[n];//记录是否访问过

        //初始化围栏
        que.add(new int[]{0, height[0], -1});
        visited[0] = 1;
        que.add(new int[]{n - 1, height[n - 1], 1});
        visited[n - 1] = 1;

        //遍历
        while (!que.isEmpty()) {
            int[] minEdge = que.poll();
            int x = (minEdge[2] == -1) ? minEdge[0] + 1 : minEdge[0] - 1;
            int dir = (minEdge[2] == -1) ? -1 : 1;
            if (x < 0 || x > n - 1 || visited[x] == 1) break;

            //update que
            que.add(new int[]{x, Math.max(minEdge[1], height[x]), dir});
            visited[x] = 1;

            //update rain
            if (height[x] < minEdge[1]) {
                rainSum = rainSum + minEdge[1] - height[x];
            }

        }

        return rainSum;

    }
}