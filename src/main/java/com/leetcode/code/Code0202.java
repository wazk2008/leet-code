package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code0202
 * @Author: ZK
 * @Date: 2021/4/5 22:25
 * @Version: 1.0
 */
public class Code0202 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(kthToLast(node1, 2));
    }

    public static int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode slow = head;

        while (k-- > 0) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            slow = slow.next;
        }

        return slow.val;
    }

}
