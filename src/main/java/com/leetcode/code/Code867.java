package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code867
 * @Author: ZK
 * @Date: 2021/2/25 21:58
 * @Version: 1.0
 */
public class Code867 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        int[][] res = transpose(matrix);
        int row = res.length;
        int col = res[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

}
