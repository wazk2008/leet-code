package com.leetcode.code;

import java.util.*;

public class Code726 {

    public static void main(String[] args) {
//        String formula = "K4(ON(SO3)2)2";
//        String formula = "H2O";
//        String formula = "H11He49NO35B7N46Li20";
        String formula = "(NB3)33";
        System.out.println(countOfAtoms(formula));

    }

    static class Atomic{
        String name;
        Integer count;
        public Atomic(){}
        public Atomic(String name, Integer count){
            this.name = name;
            this.count = count;
        }
    }

    public static String countOfAtoms(String formula) {
        int len = formula.length();

        int index = 0;
        Stack<Atomic> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        char[] chars = formula.toCharArray();
        while (index < len) {
//            左括号，入栈
            if (chars[index] == '(') {
                stack.push(new Atomic("(", -1));
                index++;
            } else if (chars[index] == ')') {
//                右括号，出栈
                index++;
//                获取右括号右边的数量
                int count = getNum(formula, index);
//                获取右括号后边的数量后，index的位移 [考虑(..)NO]，右括号后边直接是字符的情况
                if (index < len && '0' <= chars[index] && chars[index] <= '9') {
                    index += String.valueOf(count).length();
                }
//                出栈，添加到map中，并去重
                while (stack != null && !stack.peek().name.equals("(")) {
                    Atomic atomic = stack.pop();
                    atomic.count = atomic.count * count;
                    map.put(atomic.name, map.getOrDefault(atomic.name, 0)+atomic.count);
                }
//                将栈顶的左括号出栈
                stack.pop();
//                将map中的atomic重新入栈
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    stack.push(new Atomic(entry.getKey(), entry.getValue()));
                }
//                清空map
                map.clear();
            } else {
//                获取原子
                String name = getAtomic(formula, index);
//                获取数字
                int num = getNum(formula, index += name.length());

//                获取数字完毕后的位移
                if (index < len && '0' <= chars[index] && chars[index] <= '9') {
                    index += String.valueOf(num).length();
                }

//                封装atomic并入栈
                Atomic atomic = new Atomic(name, num);
                stack.push(atomic);
            }
        }

//        放入到map中并去重
        for (Atomic atomic : stack) {
            map.put(atomic.name, map.getOrDefault(atomic.name, 0)+atomic.count);
        }

//        将map中的atomic添加到list中
        List<Atomic> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Atomic(entry.getKey(), entry.getValue()));
        }

//        list排序
        list.sort(new Comparator<Atomic>() {
            @Override
            public int compare(Atomic o1, Atomic o2) {
                return o1.name.compareTo(o2.name);
            }
        });

//        统计结果，拼接sb
        StringBuilder sb = new StringBuilder();
        for (Atomic atomic : list) {
            sb.append(atomic.name);
//            如果数量为1，则不拼接
            if (atomic.count != 1) {
                sb.append(atomic.count);
            }
        }
        return sb.toString();
    }

    /**
     * 获取下一个原子
     * @param formula K4(ON(SO3)2)2     Fe3O4
     * @param index 0   3               0
     * @return      K   O               Fe
     */
    public static String getAtomic(String formula, int index){
        char[] chars = formula.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        sb.append(chars[index]);

        index++;
        while (index < len && 'a' <= chars[index] && chars[index] <= 'z') {
            sb.append(chars[index++]);
        }

        return sb.toString();
    }

    /**
     * 获取下一个数字
     * @param formula   K4(ON(SO3)2)2     (NB3)33
     * @param index     1   3               1   2   5
     * @return          4   1               1   3   33
     */
    public static int getNum(String formula, int index){
        int len = formula.length();
        char[] chars = formula.toCharArray();
        int n = 0;

        while (index < len && '0' <= chars[index] && chars[index] <= '9') {
            n = n*10 + chars[index++]-'0';
        }

        return n==0 ? 1 : n;
    }



}
