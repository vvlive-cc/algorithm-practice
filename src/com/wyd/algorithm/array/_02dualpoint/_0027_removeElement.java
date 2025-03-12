package com.wyd.algorithm.array._02dualpoint;

/**
 * @Author: wyd
 * @Description: 移除元素（ 原地 移除） https://leetcode.cn/problems/remove-element/
 * @Date: 2025/3/11
 */
public class _0027_removeElement {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 6;
        System.out.println(removeElement(nums, target));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 双指针（快慢）
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
