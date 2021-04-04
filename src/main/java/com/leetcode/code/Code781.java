package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @ClassName: Code781
 * @Author: ZK
 * @Date: 2021/4/4 00:21
 * @Version: 1.0
 */
public class Code781 {

    public static void main(String[] args) {
//        int[] answers = {1,1,1,2,2};
        int[] answers = {10,10,10};
        System.out.println(numRabbits(answers));
    }

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = answers.length;
        for (int i = 0; i < len; i++) {
            int num = answers[i];
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            设有x只兔子回答了y
//            则至少有x/(y+1)中不同的颜色
//            例如{3,3,3,3}，4/(3+1)=1种不同的颜色
//            例如{3,3,3,3, 3,3,3,3}，8/(3+1)=2种不同的颜色
//            例如{3,3,3,3, 3,3}，6/(3+1)=1种不同的颜色，其实这时候应该是2种不同颜色的，所以需要向上取整
//            即：x/(y+1)为整数时，恰好就是x/(y+1)种不同的颜色
//               x/(y+1)为小数时，应该是x/(y+1)+1种不同的颜色
//            归并以上两种情况，=> (x+y)/(y+1)种不同的颜色

//            每种颜色的兔子，最多有y+1只，故有如下的式子
            int y = entry.getKey();
            int x = entry.getValue();
            res += (x+y)/(y+1)*(y+1);
        }

        return res;
    }

}
