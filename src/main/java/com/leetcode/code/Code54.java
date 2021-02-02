package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code54
 * @Author ZK
 * @Description
 * @Date 2021/2/2 15:04
 * @Version 1.0
 **/
public class Code54 {

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{7},{9},{6}};
        List<Integer> list = spiralOrder(matrix);
        for (Integer i : list) {
            System.out.print(i + "\t");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;

        while (left <= right && top <= bottom) {
//            右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
//            向下走不动的时候，直接break
            if (top == bottom) {
                break;
            }
//            下
            for (int i = top+1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
//            向左走不懂的时候，直接break
            if (left == right) {
                break;
            }
//            左
            for (int i = right-1; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
//            上
            for (int i = bottom-1; i >= top+1; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }


}
