package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: Code52
 * @Author: ZK
 * @Date: 2021/1/30 16:13
 * @Version: 1.0
 */
public class Code52 {

    public static void main(String[] args) {
        int n = 4;
        int res = totalNQueens(n);
        System.out.println(res);
    }

    public static int totalNQueens(int n) {
        int[] arr = new int[n];
        List<int[]> res = new ArrayList<>();
        solve(res, arr, n, 0);
        return res.size();
    }

    /**
     * 递归回溯填写8皇后问题
     * @param res   记录所有的结果
     * @param arr   记录结果的一维数组，下标i表示第i+1个皇后，arr[i]表示第i+1个皇后在第i+1行的具体纵坐标
     * @param n     n个皇后
     * @param cur   当前在摆放第cur个皇后
     */
    public static void solve(List<int[]> res,int[] arr, int n, int cur){
//        当前已经摆放到n个皇后，表示n皇后已经摆放完毕
        if ( cur == n) {
            res.add(arr);
            return;
        }
//        依次放入皇后，并判断是否发生了冲突
        for (int i = 0; i < n; i++) {
//            把当前这个皇后，依次往0-n的位置摆放，判断是否会发生冲突
            arr[cur] = i;
//            未发生冲突
            if (judge(arr, cur)) {
//                继续向下摆放下一个皇后
                solve(res, arr, n, cur+1);
            }
//            else，发生了冲突，回到循环头部，将当前这个皇后向后摆放一个位置，继续判断是否冲突
        }
    }

    /**
     * 判断放置的第cur个皇后，是否和前边已经摆放好的发生了冲突
     * @param arr   记录结果的一维数组
     * @param cur   当前摆放的第cur个皇后
     * @return      false：有冲突   true：无冲突
     */
    public static boolean judge(int[] arr, int cur){
//        i表示n前边的第几个皇后
        for (int i = 0; i < cur; i++) {
//            arr[i] == arr[cur]  表示同一列是否有冲突
//            Math.abs(cur-i) == Math.abs(arr[cur]-arr[i])  表示统一斜线上是否有冲突
            if (arr[i] == arr[cur] || Math.abs(cur-i) == Math.abs(arr[cur]-arr[i])){
                return false;
            }
        }
        return true;
    }


}
