package com.leetcode.code;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Code46
 * @Author ZK
 * @Description
 * @Date 2021/1/28 16:02
 * @Version 1.0
 **/
public class Code46Not {

    public static void main(String[] args) {
        int[] arr = {2,4,6,8};
        List<List<Integer>> list = permute(arr);
        for (List<Integer> i : list) {
            System.out.println(i);
        }


    }




    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int len = nums.length;
        backtrack(len, output, res, 0);
        return res;
    }


    public static void backtrack(int len, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == len) {
            res.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = first; i < len; i++) {
            if (i != first) {
                // 动态维护数组
                Collections.swap(output, first, i);
            }

            // 继续递归填下一个数
            backtrack(len, output, res, first + 1);

            if (i != first) {
                // 撤销操作
                Collections.swap(output, first, i);
            }

        }
    }



}
