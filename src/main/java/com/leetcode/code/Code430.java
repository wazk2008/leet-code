package com.leetcode.code;

public class Code430 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

//        node1.next = node2;
//        node2.prev = node1;
//        node2.next = node3;
//        node3.prev = node2;
//        node3.next = node4;
//        node4.prev = node3;
//        node4.next = node5;
//        node5.prev = node4;
//        node5.next = node6;
//        node6.prev = node5;
//
//        node7.next = node8;
//        node8.prev = node7;
//        node8.next = node9;
//        node9.prev = node8;
//        node9.next = node10;
//        node10.prev = node9;
//
//        node11.next = node12;
//        node12.prev = node11;
//
//        node3.child = node7;
//
//        node8.child = node11;


        node1.child = node2;
        node2.child = node3;


        flatten(null);
        System.out.println();
    }

    public static Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private static Node dfs(Node head){
        // last表示每一行的最后一个有效节点
        // 起初设置last为该行的第一个节点
        Node last = head;
        while (true) {
            if (last.child == null) {
                if (last.next == null) {
                    return last;
                }
                last = last.next;
            } else {
                // 指针1，获取next
                Node next = last.next;
                // 指针2，获取子节点
                Node child = last.child;
                // 与子节点断开链接
                last.child = null;

                // 将下一个节点指向子节点
                last.next = child;
                // 设置子节点的前驱
                child.prev = last;

                // 获取下一行的最后一个有效节点
                // 也就是last指向了下一行的最后一个有效节点
                last = dfs(child);

                // 回溯连接该行的next节点
                last.next = next;
                // 如果next不为空则设置前驱
                if (next != null) {
                    next.prev = last;
                }
            }
        }
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(){}
    public Node(int val){this.val = val;}
};
