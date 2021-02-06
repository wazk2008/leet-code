package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code1423
 * @Author: ZK
 * @Date: 2021/2/6 17:49
 * @Version: 1.0
 */
public class Code1423 {

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        System.out.println(maxScore(cardPoints, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum = 0;
//        1.先计算出最后k个的总和
        for (int i = len-k; i < len; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
//        2.变形窗口开始滑动滑动
        for (int i = 0; i < k; i++) {
            sum = sum + cardPoints[i] - cardPoints[len-k+i];
            max = Math.max(sum, max);
        }
        return max;
    }

}
