package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code766
 * @Author: ZK
 * @Date: 2021/2/22 00:45
 * @Version: 1.0
 */
public class Code766 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j < col-1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
