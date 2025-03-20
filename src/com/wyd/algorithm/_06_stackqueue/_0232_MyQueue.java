package com.wyd.algorithm._06_stackqueue;

import java.util.Stack;

/**
 * @Author: wyd
 * @Description: 用栈实现队列
 * @Date: 2025/3/20
 */
public class _0232_MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public _0232_MyQueue() {
    }

    /**
     * 入队（队尾）
     * @param x 元素
     */
    public void push(int x) {
        if (!stack2.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        stack1.push(x);
    }

    /**
     * 出队（队头）
     * @return 元素
     */
    public int pop() {

        if (!stack1.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    /**
     * 返回对头元素
     * @return 元素
     */
    public int peek() {

        if (!stack1.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    /**
     * 是否空队列
     * @return 是否
     */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        _0232_MyQueue myQueue = new _0232_MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();
        myQueue.empty();
    }
}
