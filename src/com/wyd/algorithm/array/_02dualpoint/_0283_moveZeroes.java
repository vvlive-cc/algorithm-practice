package com.wyd.algorithm.array._02dualpoint;

import java.util.Arrays;

/**
 * @Author: wyd
 * @Description: 移动零(原地操作) https://leetcode.cn/problems/move-zeroes/
 * @Date: 2025/3/11
 */
public class _0283_moveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
