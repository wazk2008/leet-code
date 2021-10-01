package com.leetcode.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code1436 {

    public static void main(String[] args) {

    }

    public static String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        String res = paths.get(0).get(0);
        while (map.containsKey(res)) {
            res = map.get(res);
        }

        return res;
    }

}
