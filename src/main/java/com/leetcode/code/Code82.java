package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code82
 * @Author: ZK
 * @Date: 2021/3/25 22:16
 * @Version: 1.0
 */
public class Code82 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = deleteDuplicates(node1);


        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode temp = dummyHead;
        while(temp.next != null && temp.next.next != null){
            if (temp.next.val == temp.next.next.val) {
                int val = temp.next.val;
                while(temp.next != null && temp.next.val == val){
                    temp.next = temp.next.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

}

