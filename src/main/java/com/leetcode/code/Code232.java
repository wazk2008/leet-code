package com.leetcode.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @ClassName: Code232
 * @Author: ZK
 * @Date: 2021/3/5 23:38
 * @Version: 1.0
 */
public class Code232 {

//    定义两个双端队列：是一种具有队列和栈的性质的数据结构。
    Deque<Integer> in;
    Deque<Integer> out;

    public Code232() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
//        直接添加到in栈中
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
//        判断out栈中是否存在元素
        if (out.isEmpty()) {
//            如果不存在，则将in栈中的所有元素都添加到out栈中
            twiceDeal();
        }
//        直接弹出out栈中的栈顶元素
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
//        判断out栈中是否存在元素
        if (out.isEmpty()) {
//            如果不存在，则将in栈中的所有元素都添加到out栈中
            twiceDeal();
        }
//        直接获取out栈中的栈顶元素
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
//        判断out栈是否为空，同时需判断in栈中是否存在元素
//        in栈中如果存在元素，说明有数据添加进来未弹出
        return out.isEmpty() && in.isEmpty();
    }

    /**
     * 将in栈中的元素全部添加到out栈中
     */
    private void twiceDeal(){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }

}
