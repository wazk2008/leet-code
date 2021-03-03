package com.leetcode.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:
 * @ClassName: Code304
 * @Author: ZK
 * @Date: 2021/3/2 23:12
 * @Version: 1.0
 */
public class Code304 {

    int[][] sums;

    public Code304(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        sums = new int[row+1][col+1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sums[i+1][j+1] = sums[i+1][j] + sums[i][j+1] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row1][col2+1] - sums[row2+1][col1] + sums[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}
        };
        Code304 code304 = new Code304(matrix);
        int sum = code304.sumRegion(2, 1, 4, 3);
        System.out.println(sum);
    }

}
