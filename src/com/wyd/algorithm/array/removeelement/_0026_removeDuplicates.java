package com.wyd.algorithm.array.removeelement;

/**
 * @Author: wyd
 * @Description: 删除有序数组中的重复项 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * @Date: 2025/3/11
 */
public class _0026_removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }

        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        return slow;
    }
}
