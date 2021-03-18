package com.leetcode.code;


import java.util.Stack;

/**
 * @Description:
 * @ClassName: code92
 * @Author: ZK
 * @Date: 2021/3/18 23:24
 * @Version: 1.0
 */
public class code92 {

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

        ListNode head = reverseBetween(node1, 1, 2);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
//        定义栈，用来存储需要反转的节点
        Stack<ListNode> stack = new Stack<>();
//        定义计数器，表示当前遍历的节点个数
        int count = 1;
//        定义一个空的头节点
        ListNode dummyHead = new ListNode(-1);
//        空的头节点连接head
        dummyHead.next = head;
//        定义一个临时节点，指向头节点
        ListNode temp = head;
//        定义前缀节点，也就是需要反转的前一个节点
//        前缀节点指向空头节点，是为了防止left=1的情况
        ListNode prefix = dummyHead;
//        定义后继节点，也就是反转区间的下一个节点
//        后继节点为null，是为了防止right为最后一个节点
        ListNode suffix = null;
//        定义死循环，结束条件就是遍历完反转区间
//        或者循环结束条件为 temp != null
        while(true){
//            如果当前计数小于left，前驱节点后移
            if (count < left) {
                prefix = prefix.next;
            }
//            如果当前计数在[left，right]之间，则是需要反转的节点，入栈
            if (count >= left && count <= right) {
                stack.push(temp);
            }
//            如果当前计数大于right，则反转区间遍历完毕，suffix指向反转区间的下一个节点，直接break
            if (count > right) {
                suffix = temp;
                break;
            }
//            每次循环，计数器++，临时节点后移
            count++;
            temp = temp.next;
        }

//        将前缀节点依次把反转区间串联起来
        while(!stack.isEmpty()){
            prefix.next = stack.pop();
            prefix = prefix.next;
        }
//        串联完毕后，前缀节点为反转区间的最后一个元素，需要将后缀节点连起来
        prefix.next = suffix;
//        返回空头节点的下一个元素
        return dummyHead.next;
    }


}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



