package com.leetcode.code;

import java.util.PriorityQueue;

public class Code407 {

    public static void main(String[] args) {

    }
    static int[] dir = {-1, 0, 1, 0, -1};
    public int trapRainWater(int[][] heightMap) {
        // 解决特殊情况
        int r = heightMap.length;
        int c = heightMap[0].length;
        if (r<3 || c<3) {
            return 0;
        }

        // 构建优先队列，将最外圈放入到队列中，同时标记visited
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i==0 || i==r-1 || j==0 || j==c-1) {
                    queue.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        // 循环从队列中取出元素，遍历其周围元素，如果找到比他小的内部节点，就灌水到等高
        // 元素出队，入队内部节点，标记visited
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 遍历 上 右 下 左 4个方向
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dir[i];
                int y = cur[1] + dir[i+1];
                if (0<=x && x<r && 0<=y && y<c && !visited[x][y]) {
                    int temp = cur[2] - heightMap[x][y];
                    if (temp > 0) {
                        res += temp;
                    }
                    queue.offer(new int[]{x, y, Math.max(cur[2], heightMap[x][y])});
                    visited[x][y] = true;
                }
            }
        }

        return res;
    }


}
