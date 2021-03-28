package com.leetcode.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @ClassName: Code354
 * @Author: ZK
 * @Date: 2021/3/28 20:18
 * @Version: 1.0
 */
public class Code354 {

    public static void main(String[] args) {
//        int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
//        int[][] envelopes = {{1,1},{1,1},{1,1}};
//        int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}};
        int[][] envelopes = {{30,50},{12,2},{3,4},{12,15}};

        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;

//        二维数组排序，如果第一个相等，第二个则按照降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0] == 0 ? o2[1]-o1[1] : o1[0]-o2[0];
            }
        });

        int[] res = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++ ) {
            for (int j = 0; j < i; j++) {
//                只需要比较后者的第二元素是否大于前者
//                当前第二元素和之前所有的第二元素进行比较，如果大于
                if (envelopes[i][1] > envelopes[j][1]) {
                    res[i] = Math.max(res[i], res[j]+1);
                }
            }
            max = Math.max(res[i], max);
        }



        for (int i = 0; i < envelopes.length; i++) {
            System.out.println(envelopes[i][0] + "\t" + envelopes[i][1] + "\t\t" + res[i]);
        }


        return max+1;
    }

}
