package com.leetcode.code;

/**
 * @ClassName Code1128
 * @Author ZK
 * @Description
 * @Date 2021/1/26 11:00
 * @Version 1.0
 **/
public class Code1128 {

    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6},{1,2}};
        int count = numEquivDominoPairs(dominoes);
        System.out.println(count);
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[][] map = new int[10][10];

        for (int i = 0; i < dominoes.length; i++) {

            int x = Math.min(dominoes[i][0], dominoes[i][1]);
            int y = Math.max(dominoes[i][0], dominoes[i][1]);

            if (map[x][y] != 0) {
                count += map[x][y];
            }

            map[x][y]++;
        }

        return count;
    }

}
