package com.wyd.algorithm._06_stackqueue;

import java.util.Stack;

/**
 * @Author: wyd
 * @Description: 逆波兰表达式求值
 * @Date: 2025/3/24
 */
public class _0150_evalRPN {

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b + a));
            } else if (s.equals("-")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b - a));
            } else if (s.equals("*")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b * a));
            } else if (s.equals("/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b / a));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
