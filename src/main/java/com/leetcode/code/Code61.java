package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code61
 * @Author: ZK
 * @Date: 2021/3/28 19:44
 * @Version: 1.0
 */
public class Code61 {

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


        ListNode head = rotateRight(node1, 2);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

//        求链表的长度
        int size = 0;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
//        形成环链
        temp.next = head;

//        定义一个空头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        for (int i = 0; i < size-(k%size); i++) {
            dummyNode = dummyNode.next;
        }
//        定义输出节点
        ListNode res;
//        输出节点固定
        res = dummyNode.next;
//        将输出节点的前一个节点的next置空
        dummyNode.next = null;

        return res;
    }

}
