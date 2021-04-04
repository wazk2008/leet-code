package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code88
 * @Author: ZK
 * @Date: 2021/4/5 00:07
 * @Version: 1.0
 */
public class Code88 {

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + "\t");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idxm = m-1;
        int idxn = n-1;
        int len = nums1.length-1;

        while(idxm >= 0 || idxn >= 0){
            if (idxm < 0) {
                nums1[len--] = nums2[idxn];
                idxn--;
            } else if (idxn < 0) {
                break;
            } else if (nums1[idxm] >= nums2[idxn]) {
                nums1[len--] = nums1[idxm];
                idxm--;
            } else {
                nums1[len--] = nums2[idxn];
                idxn--;
            }
        }
    }

}
