package com.leetcode.code;

import java.util.TreeSet;

/**
 * @Description:
 * @ClassName: Code363
 * @Author: ZK
 * @Date: 2021/4/22 23:01
 * @Version: 1.0
 */
public class Code363 {

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix, k));
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

//        预处理前缀和
        int[][] sum = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + matrix[i][j];
            }
        }

        int res = Integer.MIN_VALUE;
//        遍历子矩阵的上边界
        for (int top = 1; top <= m; top++) {
//            遍历子矩阵的下边界
            for (int bot = top; bot <= m; bot++) {
//                使用【有序集合】维护所有遍历的右边界
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
//                遍历子矩阵的右边界
                for (int r = 1; r <= n; r++) {
//                    通过前缀和计算 right
                    int right = sum[bot][r] - sum[top-1][r];
//                    通过二分查找 left
                    Integer left = set.ceiling(right - k);
                    if (left != null) {
                        int cur = right - left;
                        res = Math.max(res, cur);
                    }
//                    将遍历过的 right 添加到有序集合中
                    set.add(right);
                }
            }
        }
        return res;
    }


}
