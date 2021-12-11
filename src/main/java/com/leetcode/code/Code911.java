package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code911 {

    public static void main(String[] args) {
        int[] persons = {0, 1, 1,  0,  0,  1,  0};
        int[] times =   {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
        System.out.println(topVotedCandidate.q(14));
    }

}

class TopVotedCandidate {

    List<int[]> list = new ArrayList<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        // 记录一下最大票数
        int val = 0;
        // key:   第i张票时的候选人
        // value: 第i张票时的候选人的总票数，加上当前这一张票
        Map<Integer, Integer> map = new HashMap<>();
//        int person = persons[0];
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0)+1);
            if (map.get(persons[i]) >= val) {
//                person = persons[i];
                val = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
//            } else {
//                list.add(new int[]{times[i], person});
            }
        }
    }

    public int q(int t) {
        int left = 0;
        int right = list.size()-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (list.get(mid)[0] <= t) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return list.get(right)[0] <= t ? list.get(right)[1] : 0;
    }
}










