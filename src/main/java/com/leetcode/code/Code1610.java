package com.leetcode.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code1610 {

    public static void main(String[] args) {
        System.out.println(Math.sin(0.5));
        System.out.println(Math.asin(1.0 / 2));
        System.out.println(Math.sinh(0.5));
    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int same = 0;
        List<Double> list = new ArrayList<>();
        int x = location.get(0);
        int y = location.get(1);
        for (List<Integer> point : points) {
            int x1 = point.get(0);
            int y1 = point.get(1);
            // 判断是否与原点location相同
            if (x1==x && y1==y) {
                same++;
            } else {
                list.add(Math.atan2(y1-y, x1-x));
            }
        }
        // 排序
        Collections.sort(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(list.get(i) + 2*Math.PI);
        }

        double angleDegree = angle * Math.PI / 180;
        int max = 0;
        int i = 0, j=0;
        while (i < size) {
            while (j < 2*size && list.get(j)-list.get(i) <= angleDegree) {
                j++;
            }
            max = Math.max(max, j-i);
            i++;
        }
        return max + same;
    }

}
