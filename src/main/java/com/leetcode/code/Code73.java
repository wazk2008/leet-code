package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code73
 * @Author: ZK
 * @Date: 2021/3/21 22:48
 * @Version: 1.0
 */
public class Code73 {

    public static void main(String[] args) {
        int[][] matrix = {{3,5,5,6,9,1,4,5,0,5},{2,7,9,5,9,5,4,9,6,8},{6,0,7,8,1,0,1,6,8,1},{7,2,6,5,8,5,6,5,0,6},{2,3,3,1,0,4,6,5,3,5},{5,9,7,3,8,8,5,1,4,3},{2,4,7,9,9,8,4,7,3,7},{3,5,2,8,8,2,2,4,9,8}};

        show(matrix);

        setZeroes(matrix);
        System.out.println();
        System.out.println();
        System.out.println();

        show(matrix);

    }

    public static void show(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean rowFlag = false;
        boolean colFlag = false;

//        判断第一行是否有0
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
//        判断第一列是否有0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

//        把第一行第一列作为标识位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
//                    此处不能有break，防止一行中有多个0，第2个0对应的列无法置0
//                    break;
                }
            }
        }

        System.out.println("把第一行第一列作为标识位");
        show(matrix);

//        通过标识位置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("通过标识位置0");
        show(matrix);

//        判断第一行
        if (rowFlag) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
