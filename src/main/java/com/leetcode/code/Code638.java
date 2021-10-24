package com.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code638 {

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2, 5));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 0, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 10));
        List<List<Integer>> special = new ArrayList<>();
        special.add(list1);
        special.add(list2);
        List<Integer> needs = new ArrayList<>(Arrays.asList(3, 2));

        System.out.println(shoppingOffers(price, special, needs));
    }

    // 最小花费
    static int minCost;

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 获取有效的大礼包
        List<List<Integer>> filterSpecial = filterSpecial(price, special, needs);

        // res为不用大礼包时的花费
        minCost = calcCost(price, needs);
        System.out.println(minCost);
        dfs(price, filterSpecial, needs, new int[needs.size()], 0);

        return minCost;
    }

    // 过滤无效的大礼包
    private static List<List<Integer>> filterSpecial(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        int len = price.size();
        List<List<Integer>> filterSpecial = new ArrayList<>();
        for (List<Integer> list : special) {
            // 判断当前大礼包是否为有效的大礼包，大礼包中的数量是否大于购买数量
            boolean valid = true;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                // 大礼包中的数量大于购买数量
                if (list.get(i) > needs.get(i)) {
                    valid = false;
                    break;
                }
                sum += list.get(i)*price.get(i);
            }
            // 有效大礼包
            if (valid && sum > list.get(len)) {
                filterSpecial.add(list);
            }
        }
        return filterSpecial;
    }

    // 不用大礼包时的花费
    private static Integer calcCost(List<Integer> price, List<Integer> needs){
        Integer cost = 0;
        int len = needs.size();
        for (int i = 0; i < len; i++) {
            cost += needs.get(i)*price.get(i);
        }
        return cost;
    }


    /**
     * dfs
     * @param price     价格
     * @param special   过滤后的有效大礼包
     * @param needs     总的购买需求
     * @param cur       当前状态的购买需求
     * @param curCost   当前大礼包的花费
     */
    private static boolean dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int[] cur, int curCost){
        int len = cur.length;
        // 递归出口
        // 判断当前购买数量是否超过总量
        for (int i = 0; i < len; i++) {
            if (cur[i] > needs.get(i)) {
                return true;
            }
        }

        // 继续购买大礼包
        for (List<Integer> list : special) {
            // 计算购买当前大礼包之后的cur和curCost
            for (int i = 0; i < len; i++) {
                cur[i] += list.get(i);
            }
            curCost += list.get(len);

            boolean flag = dfs(price, special, needs, cur, curCost);
            // 回溯，恢复上次的购买状态
            for (int i = 0; i < len; i++) {
                cur[i] -= list.get(i);
            }
            curCost -= list.get(len);

            // 判断是否买到了最多的大礼包情况
            if (flag) {
                int total = 0;
                for (int i = 0; i < len; i++) {
                    total += (needs.get(i)-cur[i])*price.get(i);
                }
                minCost = Math.min(minCost, total+curCost);
                show(cur, minCost);
            }
        }
        return false;
    }

    private static void show(int[] cur, int minCost){
        int len = cur.length;
        for (int i = 0; i < len; i++) {
            System.out.print(cur[i] + "\t");
        }
        System.out.println(minCost);
        System.out.println();
    }

}
