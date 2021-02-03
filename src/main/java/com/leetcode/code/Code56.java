package com.leetcode.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Code56
 * @Author ZK
 * @Description
 * @Date 2021/2/3 14:56
 * @Version 1.0
 **/
public class Code56 {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{15,18},{8,10},{2,6}};
        int[][] ints = merge(intervals);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public static int[][] merge(int[][] intervals) {

//        排序，按照区间的起点进行排序
//        这里提供两种排序的写法，只是语法不一样而已
//        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int len = intervals.length;
//        定义返回的二维数组，其长度为输入数组长度len，肯定够用，可能会有空余，返回时处理
        int[][] res = new int[len][2];
//        下标记录
        int index = 0;
//        定义一个临时数组，临时数组的值先记录第一个
        int[] temp = {intervals[0][0],intervals[0][1]};
//        从第二个开始遍历，因为第一个已经被临时数组记录过了
        for (int i = 1; i < len; i++) {
//            得到每一个数组
            int[] cur = intervals[i];

//            判断每一个数组的起始下标所处位置
//            当前数组的起始位置位于临时数组的内部
            if (cur[0] >= temp[0] && cur[0] <= temp[1]) {
//                判断每一个数组的结束下标所处位置
//                当前数组的结束下标位于临时数组的内部，则不用处理，是被临时数组包含的关系
                if (cur[1] <= temp[1]) {
//                    temp不变
                } else {
//                    当前数组的结束下标位于临时数组的右边，需要处理
//                    将临时数组的右边界，修改为当前数组的右边界，相当于进行了合并
                    temp[1] = cur[1];
                }
            }else{  // 此时：cur[0] > temp[1]，当前数组的起始位置在临时数组的右边，相当于两个区间没有交集
//                由于事先已经对于区间按照起始下标进行了排序
//                所以后续的区间也不会再和临时数组有任何交集了，临时区间可以作为一个结果进行保存了
                res[index++] = temp;
//                再将当前数组变成临时数组，依次与后边的区间进行对比
                temp = cur;
            }
        }
//        最后将最终的临时数组也记录到结果中保存下来
        res[index] = temp;

//        返回结果数组res中的有效元素，也就是index+1个
        return Arrays.copyOf(res, index+1);
    }

}
