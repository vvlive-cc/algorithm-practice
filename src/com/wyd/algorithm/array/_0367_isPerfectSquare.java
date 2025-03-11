package com.wyd.algorithm.array;

/**
 * @Author: wyd
 * @Description: 有效的完全平方数 https://leetcode.cn/problems/valid-perfect-square
 * @Date: 2025/3/11
 */
public class _0367_isPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }

    public static boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid == num) {
                return true;
            }
            if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
