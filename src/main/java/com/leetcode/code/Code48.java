package com.leetcode.code;

/**
 * @ClassName Code48
 * @Author ZK
 * @Description
 * @Date 2021/1/29 14:38
 * @Version 1.0
 **/
public class Code48 {

    public static void main(String[] args) {
        int[][] arr = {{ 5, 1, 9,11},
                       { 2, 4, 8,10},
                       {13, 3, 6, 7},
                       {15,14,12,16}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }


        rotate(arr);
        System.out.println();
        System.out.println();
        System.out.println();


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;

//        1.\翻转
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

//        2.|翻转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = temp;
            }
        }

    }

}
