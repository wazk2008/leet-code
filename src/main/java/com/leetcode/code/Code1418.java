package com.leetcode.code;

import java.util.*;

public class Code1418 {

    public static void main(String[] args) {

    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
//        记录菜品的种类
        Set<String> set = new TreeSet<>();
//        key : 桌号
//        val : key:菜品
//              val:数量
        Map<String, Map<String, Integer>> map = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

        for (List<String> order : orders) {
            String table = order.get(1);
            String food = order.get(2);

            set.add(food);

            Map<String, Integer> cnt = map.getOrDefault(table, new TreeMap<>());
            cnt.put(food, cnt.getOrDefault(food, 0)+1);

            map.put(order.get(1), cnt);
        }

        List<List<String>> res = new ArrayList<>();

//        表头
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(set);
        res.add(head);

//        处理表头下边的菜品
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();

            String table = entry.getKey();
            list.add(table);
            for (String food : set) {
                list.add(entry.getValue().getOrDefault(food, 0).toString());
            }
            res.add(list);
        }

        return res;
    }

}
