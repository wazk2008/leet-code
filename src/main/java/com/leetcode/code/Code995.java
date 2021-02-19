package com.leetcode.code;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName Code995
 * @Author ZK
 * @Description
 * @Date 2021/2/18 13:31
 * @Version 1.0
 **/
public class Code995 {

    public static void main(String[] args) {
        for (int i = 1; i < 17; i++) {
//            System.out.print("[条件道岔"+i+"ID],[道岔"+i+"状态],");
            System.out.print("dc"+i+"id,dc"+i+"zt,");
        }
    }

    public static int minKBitFlips(int[] A, int K) {
        int res = 0;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (queue.size()>0 && i > queue.peek()+K-1) {
                queue.poll();
            }
            if (queue.size() % 2 == A[i]) {
                if (i + K > len) {
                    return -1;
                }
                queue.add(i);
                res++;
            }
        }
        return res;
    }

}
