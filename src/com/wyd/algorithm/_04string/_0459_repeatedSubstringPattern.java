package com.wyd.algorithm._04string;

/**
 * @Author: wyd
 * @Description: 重复的子字符串
 * @Date: 2025/3/20
 */
public class _0459_repeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "ababc";
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 移动匹配
     * 字符串 str = s + s（去掉首尾字符），str 包含 s 的子串，则 s 是重复字串。
     */
    /*public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        String str = (s + s).substring(1, 2 * len - 1);
        if (str.contains(s)) {
            return true;
        } else {
            return false;
        }
    }*/


    /**
     * KMP 算法
     */
    public static boolean repeatedSubstringPattern(String s) {
        // 1.获取 next 数组
        int[] next = getNext(s);

        // 2.判断重复子字符串
        // abcabc [0, 0, 0, 1, 2, 3] , 字符串长度 - 最长公共前后缀长度 = 重复字符串长度
        int n = s.length();
        if (next[n - 1] > 0 && n % (n - next[n - 1]) == 0) { // 当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时
            return true; // 不包含的子串就是s的最小重复子串
        } else {
            return false;
        }
    }

    public static int[] getNext(String s) {
        int len = s.length();
        int[] next = new int[len];
        next[0] = -1;
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
