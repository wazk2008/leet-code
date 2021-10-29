package com.leetcode.code;

public class Code335 {

    public static void main(String[] args) {
//        int[] dis = {1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1};
//        System.out.println(isSelfCrossing(dis));

        int[] dis = {1,1,1,1};
        System.out.println(isSelfCrossing1(dis));
    }

    public static boolean isSelfCrossing1(int[] distance) {
        int len = distance.length;
        if (len < 4) {
            return false;
        }
        int i = 2;
        // 一直外卷
        while(i<len && distance[i]>distance[i-2]){i++;}
        // 外卷结束，同时到达末尾，则没有相交
        if (i == len) {return false;}

        // 外卷停止
        // 判断是否需要断开
        if (distance[i] >= distance[i-2]-(i<4 ? 0 : distance[i-4])) {
            distance[i-1] -= i<3 ? 0 : distance[i-3];
        }

        // 内卷
        i++;
        while(i<len && distance[i]<distance[i-2]){
            i++;
        }

        return i!=len;
    }


    public static boolean isSelfCrossing(int[] distance) {
        int len = distance.length;
        for (int i = 3; i < len; i++) {
            // case 1
            if (distance[i-1]<=distance[i-3] && distance[i]>=distance[i-2]) {
                return true;
            }
            // case 2
            if (i==4 && distance[i-1]==distance[i-3] && distance[i]>=distance[i-2]-distance[i-4]) {
                return true;
            }
            // case 3
            if (i>=5 && distance[i-1]>=distance[i-3]-distance[i-5] &&
                distance[i-1]<distance[i-3] &&
                distance[i-2]>distance[i-4] &&
                distance[i]>=distance[i-2]-distance[i-4]) {
                return true;
            }
        }
        return false;
    }

}
