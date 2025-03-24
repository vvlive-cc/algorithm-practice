package com.wyd.algorithm._06_stackqueue;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: wyd
 * @Description: 删除字符串中的所有相邻重复项
 * @Date: 2025/3/24
 */
public class _1047_removeDuplicates {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
//    public static String removeDuplicates(String s) {
//        if (s == null || s.isEmpty()) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
//                sb.deleteCharAt(sb.length() - 1);
//            } else {
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();
//    }

    public static String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
