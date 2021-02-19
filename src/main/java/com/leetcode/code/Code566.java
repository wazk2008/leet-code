package com.leetcode.code;

import java.util.Arrays;

/**
 * @ClassName Code566
 * @Author ZK
 * @Description
 * @Date 2021/2/17 22:07
 * @Version 1.0
 **/
public class Code566 {

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6}};

        int[][] res = matrixReshape(nums, 1, 6);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;

        if (row*col < r*c) {
            return nums;
        }

        int rowIndex = 0;
        int colIndex = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[rowIndex][colIndex++] = nums[i][j];
                if (colIndex == c) {
                    colIndex = 0;
                    rowIndex++;
                }
            }
        }

        return res;
    }


}
