package com.wyd.algorithm._06_stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: wyd
 * @Description: 用队列实现栈
 * @Date: 2025/3/20
 */
public class _0225_MyStack {
    Deque<Integer> deque = new ArrayDeque<Integer>();

    public _0225_MyStack() {

    }

    public void push(int x) {
        deque.addFirst(x);
    }

    public int pop() {
        return deque.pollFirst();
    }

    public int top() {
        return deque.peekFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
