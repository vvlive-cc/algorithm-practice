package com.wyd.algorithm._06_stackqueue;

import java.util.Stack;

/**
 * @Author: wyd
 * @Description: 有效的括号
 * @Date: 2025/3/24
 */
public class _0020_isValid {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                } else if (s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
