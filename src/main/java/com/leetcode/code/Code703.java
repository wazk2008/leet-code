package com.leetcode.code;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @Description:
 * @ClassName: Code703
 * @Author: ZK
 * @Date: 2021/2/28 19:14
 * @Version: 1.0
 */
public class Code703 {

    Queue<Integer> queue;
    int k;

    public Code703(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(60);
//            if (num > 50) {
//                System.out.println(queue.poll());
//            } else {
                queue.offer(num);
//            }
        }

        while(queue.size() > 0){
            System.out.println(queue.poll());
        }



    }


}
