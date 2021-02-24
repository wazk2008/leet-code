package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code832
 * @Author: ZK
 * @Date: 2021/2/24 21:54
 * @Version: 1.0
 */
public class Code832 {

    public static void main(String[] args) {

    }

    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length; //行大小
        int cols = A[0].length; //列大小
        int i,j;
        //水平翻转
        for(i=0;i<rows;i++) {
            for(j=0;j<cols/2;j++) {
                int k = cols-j-1;
                int temp = A[i][j];
                A[i][j] =  A[i][k];
                A[i][k] = temp;
            }
        }
        //反转图片
        for(i=0;i<rows;i++) {
            for(j=0;j<cols;j++) {
                A[i][j]=1-A[i][j];
            }
        }

        return A;
    }

}
