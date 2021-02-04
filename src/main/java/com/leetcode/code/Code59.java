package com.leetcode.code;

/**
 * @ClassName Code59
 * @Author ZK
 * @Description
 * @Date 2021/2/4 10:18
 * @Version 1.0
 **/
public class Code59 {

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;

        while(left <= right && top <= bottom){
//            右
            for (int i = left; i <= right; i++) {
                res[top][i] = count++;
            }

//            下
            for (int i = top+1; i <= bottom; i++) {
                res[i][right] = count++;
            }

//            左
            for (int i = right-1; i >= left; i--) {
                res[bottom][i] = count++;
            }
//            上
            for (int i = bottom-1; i >= top+1; i--) {
                res[i][left] = count++;
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }

}
