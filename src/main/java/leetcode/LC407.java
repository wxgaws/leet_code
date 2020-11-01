package main.java.leetcode;

import java.util.*;

/**
 * 二维接雨水问题，围栏+优先队列
 */
class LC407 {
    public int trapRainWater(int[][] heightMap) {
        int rainSum = 0;
        //优先队列，存储围栏数据，队首元素时最小值
        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> {
            return a1[2] - a2[2];
        });

        //记录坐标是否访问过
        int row = heightMap.length, col = heightMap[0].length;
        int[][] visited = new int[row][col];//1为访问

        //初始化围栏
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    que.add(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = 1;
                }
            }
        }

        //看最小元素附近点是否可灌水，并更新边界
        int[] dx = new int[]{0, 0, -1, 1};//方向数组
        int[] dy = new int[]{1, -1, 0, 0};
        while (!que.isEmpty()) {
            int[] minEdge = que.poll();
            for (int k = 0; k < 4; k++) {
                int x = minEdge[0] + dx[k];
                int y = minEdge[1] + dy[k];
                if (x < 0 || x > row - 1 || y < 0 || y > col - 1 || visited[x][y] == 1) continue;

                //que update
                que.add(new int[]{x, y, Math.max(minEdge[2], heightMap[x][y])});
                visited[x][y] = 1;

                //rain update
                if (heightMap[x][y] < minEdge[2]) {
                    rainSum = rainSum + minEdge[2] - heightMap[x][y];
                }
            }
        }

        return rainSum;
    }
}