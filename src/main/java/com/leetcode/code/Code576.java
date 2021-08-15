package com.leetcode.code;

public class Code576 {

    public static void main(String[] args) {
        System.out.println(findPaths(2,2,2,0,0));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 100000007;
//                        1000000007;
//        定义移动方向 上 右 下 左
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int res = 0;
//        dp[i][j][k] 表示移动i次之后位于坐标(j,k)位置的路径数量
        int[][][] dp= new int[maxMove+1][m][n];
        dp[0][startRow][startColumn] = 1;
//        控制i，即走了几步
        for (int i = 0; i < maxMove; i++) {
//            控制j，即移动的横坐标
            for (int j = 0; j < m; j++) {
//                控制k，即移动的纵坐标
                for (int k = 0; k < n; k++) {
                    int cnt = dp[i][j][k];
//                    如果路径数量>1，则表示即将从当前位置开始移动，开始进行动态规划
                    if (cnt > 0) {
//                        每个方向开始移动
                        for (int[] direction : directions) {
//                            移动之后的新的位置
                            int j1 = j+direction[0];
                            int k1 = k+direction[1];
//                            如果移动的位置还在地图内
                            if (0<=j1 && j1<m && 0<=k1 && k1<n) {
//                                下一步移动到达的新位置，所需的路径数量=
                                dp[i+1][j1][k1] = (dp[i+1][j1][k1]+cnt) % MOD;
                            } else { // 出界
                                res = (res+cnt) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
