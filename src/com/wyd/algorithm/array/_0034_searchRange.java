package com.wyd.algorithm.array;

/**
 * @Author: wyd
 * @Description: 在排序数组中查找元素的第一个和最后一个位置 https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * @Date: 2025/3/11
 */
public class _0034_searchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                // 循环查找，找到最左边的target
                while (result[0] > 0 && nums[result[0] - 1] == target) {
                    result[0]--;
                }
                // 循环查找，找到最右边的target
                while (result[1] < nums.length - 1 && nums[result[1] + 1] == target) {
                    result[1]++;
                }
                return result;
           } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
