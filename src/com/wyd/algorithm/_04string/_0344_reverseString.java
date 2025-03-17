package com.wyd.algorithm._04string;

/**
 * @Author: wyd
 * @Description: 反转字符串 原地修改
 * @Date: 2025/3/17
 */
public class _0344_reverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left<right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
