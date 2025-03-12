package com.wyd.algorithm.array._02dualpoint;

import java.util.Arrays;

/**
 * @Author: wyd
 * @Description: 有序数组的平方 https://leetcode.cn/problems/squares-of-a-sorted-array/
 * @Date: 2025/3/11
 */
public class _0977_sortedSquares {

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,12};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        int[] res = new int[nums.length];

        while (left <= right) {
            // 数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[index--] = nums[right] * nums[right];
                right--;
            } else {
                res[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }
}
