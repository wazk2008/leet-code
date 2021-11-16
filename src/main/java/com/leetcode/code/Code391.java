package com.leetcode.code;

import java.util.HashSet;
import java.util.Set;

public class Code391 {

    public static void main(String[] args) {
        int[][] rectangles = new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(isRectangleCover(rectangles));
    }

    public static boolean isRectangleCover(int[][] rectangles) {
        // 找到大矩形的4个定点
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        // 各个小矩形的面积和
        int sumArea = 0;

        // 计算各个定点出现的次数，如果出现了2次，则从set中移除掉
        // key: x-y 横坐标-纵坐标
        Set<String> set = new HashSet<>();

        for (int[] rectangle : rectangles) {
            // 当前小矩形的坐标
            int a1 = rectangle[0];
            int b1 = rectangle[1];
            int a2 = rectangle[2];
            int b2 = rectangle[3];

            // 比较左下角和右上角的坐标是否需要更新
            if (a1 < x1 || b1 < y1) {
                x1 = a1;
                y1 = b1;
            }
            if (a2 > x2 || b2 > y2) {
                x2 = a2;
                y2 = b2;
            }

            // 计算当前小矩形的面积
            sumArea += calcArea(a1, b1, a2, b2);

            // 计算当前小举行订单出现的次数
            calcPoint(set, a1, b1); // 左下
            calcPoint(set, a1, b2); // 左上
            calcPoint(set, a2, b1); // 右下
            calcPoint(set, a2, b2); // 右上
        }

        // 计算大矩形的面积
        int bigArea = calcArea(x1, y1, x2, y2);
        if (sumArea != bigArea) {
            return false;
        }
        System.out.println("===========");
        // 判断剩下的4个顶点
        return set.size()==4 && set.contains(getKey(x1,y1)) && set.contains(getKey(x1, y2)) && set.contains(getKey(x2, y1)) && set.contains(getKey(x2, y2));
    }

    private static int calcArea(int x1, int y1, int x2, int y2){
        return (x2-x1) * (y2-y1);
    }

    private static void calcPoint(Set<String> set, int x, int y){
        String key = getKey(x, y);
        if (set.contains(key)) {
            set.remove(key);
        } else {
            set.add(key);
        }
    }

    private static String getKey(int x, int y){
        StringBuffer sb = new StringBuffer();
        return sb.append(x).append("-").append(y).toString();
    }

}
