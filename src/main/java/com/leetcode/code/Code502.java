package com.leetcode.code;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Code502 {

    public static void main(String[] args) {
        int[] profits = {1,3,8};
        int[] capital = {0,0,1};
        int k = 2;
        int w = 0;
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

//    贪心策略

//    1.按照所需启动资金进行升序排序
//    2.从所需启动资金<=w(0)的情况下，将能启动的项目添加到queue中
//    3.从queue中挑选出最大的纯利润，并从queue中移除
//    4.再次计算所需启动资金<=w的情况下，将能启动的项目添加到queue中
//    5.再从queue中挑选出最大的纯利润，并从queue中移除
//    6.直到循环结束



    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }

//        二维数组中按照第二个元素升序排列，也就是按照启动资金进行排序
        Arrays.sort(arr, (a,b)->a[1]-b[1]);

//        构建大根堆，即降序排列
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx<len && arr[idx][1]<=w) {
                queue.offer(arr[idx++][0]);
            }
            if (!queue.isEmpty()) {
                w += queue.poll();
            } else {
                break;
            }
        }
        return w;
    }

}
