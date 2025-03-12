package com.wyd.algorithm.array._02dualpoint;

import java.util.Stack;

/**
 * @Author: wyd
 * @Description: 比较含推格的字符串 https://leetcode.cn/problems/backspace-string-compare/
 * @Date: 2025/3/11
 */
public class _0844_backspaceCompare {

    public static void main(String[] args) {
        String s = "y#fo##f", t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !characters.empty()) {
                characters.pop();
            } else if (s.charAt(i) != '#'){
                characters.push(s.charAt(i));
            }
        }
        String ss = characters.toString();

        characters.clear();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && !characters.empty()) {
                characters.pop();
            } else if (t.charAt(i) != '#') {
                characters.push(t.charAt(i));
            }
        }
        return ss.equals(characters.toString());
    }
}
