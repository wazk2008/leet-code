package com.leetcode.code;

/**
 * @ClassName Code765
 * @Author ZK
 * @Description
 * @Date 2021/2/14 23:05
 * @Version 1.0
 **/
public class Code765 {

    public static void main(String[] args) {
        int[] row = {3, 2, 0, 1};
        minSwapsCouples(row);
    }

    public static int minSwapsCouples(int[] row) {
        int len = row.length;

        int[] indexMap = new int[len];
        for (int i = 0; i < len; i++) {
            indexMap[row[i]] = i;
        }
        int count = 0;

        for (int i = 0; i < len-1; i+=2) {
            int p1 = row[i];
            int p2 = (p1&1) == 0 ? p1+1 : p1-1;
            if (row[i+1] == p2) {
                continue;
            }
            int p2Index = indexMap[p2];
            swap(row, indexMap, i+1, p2Index);
            count++;
        }
        return count;
    }

    public static void swap(int[] row, int[] indexMap, int i, int j){
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
        indexMap[row[i]] = i;
        indexMap[row[j]] = j;
    }

}
