package com.wyd.algorithm.array._01binarysearch;

/**
 * @Author: wyd
 * @Description: X 的平方根
 * @Date: 2025/3/11
 */
public class _0069_mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
    public static int mySqrt(int x) {
        int left = 0, right = x;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        // 为什么是right？ 因为最终 left > right ，所以 right 是最后一个小于等于 x 的数
        return right;
    }
}
