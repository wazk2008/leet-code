package com.leetcode.code;

public class Code240 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        System.out.println(searchMatrix(matrix, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = col-1;
        while (x<row && y>=0) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            } else if (num > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

}
