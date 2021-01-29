package com.leetcode.code;

import java.util.*;

/**
 * @ClassName Code49
 * @Author ZK
 * @Description
 * @Date 2021/1/29 15:14
 * @Version 1.0
 **/
public class Code49 {

    public static void main(String[] args) {
//        第一次设计key的时候，用排序后得到的数字，结果如下这个测试用例发生了报错
        String[] strs = {"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sort(str);
            if (map.containsKey(key)) {
                 map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }


//    对一个字符串进行排序，bedac -> abcde
    public static String sort(String str){
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

}
