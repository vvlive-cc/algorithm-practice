package com.wyd.algorithm.array._01binarysearch;

/**
 * @Author: wyd
 * @Description: 二分查找 https://leetcode.cn/problems/binary-search/description/
 * @Date: 2025/3/11
 */
public class _0704_search {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        // 左闭右闭
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
