package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code83
 * @Author: ZK
 * @Date: 2021/3/26 23:44
 * @Version: 1.0
 */
public class Code83 {

    public static void main(String[] args) {

    }



    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        while(temp.next != null){
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


}
