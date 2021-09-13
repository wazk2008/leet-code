package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

public class Code447 {

    public static void main(String[] args) {

    }

    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = points.length;
        for (int i = 0; i < len; i++) {
            int[] origin = points[i];
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    int[] temp = points[j];
                    int x = origin[0] - temp[0];
                    int y = origin[1] - temp[1];
                    int distance = x*x + y*y;
                    map.put(distance, map.getOrDefault(distance, 0)+1);
                }
            }
            for (Integer num : map.values()) {
                res += num*(num-1);
            }
            map.clear();
        }
        return res;
    }

}
