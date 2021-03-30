package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code74
 * @Author: ZK
 * @Date: 2021/3/30 22:14
 * @Version: 1.0
 */
public class Code74 {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 12;
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;

        int low = 0;
        int high = len - 1;

        while(low <= high) {
            int mid = (high + low)/2;
            int cur = matrix[mid/col][mid%col];
            if (target > cur) {
                low = mid + 1;
            } else if (target < cur) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
