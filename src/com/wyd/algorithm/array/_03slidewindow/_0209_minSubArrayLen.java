package com.wyd.algorithm.array._03slidewindow;

/**
 * @Author: wyd
 * @Description: 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 * @Date: 2025/3/12
 */
public class _0209_minSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,7};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 滑动窗口: 总和大于等于 target 的长度最小的 子数组
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        int sum = nums[0];

        while (left <= right) {
            if (sum < target) {
                if (right >= nums.length - 1) {
                    break;
                }
                sum += nums[++right];
            } else {
                len = Math.min(len, right - left + 1);
                if (left >= nums.length - 1) {
                    break;
                }
                sum -= nums[left++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
