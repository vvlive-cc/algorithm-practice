package com.wyd.algorithm._05.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wyd
 * @Description: 三数之和 https://leetcode.cn/problems/3sum/
 * @Date: 2025/3/14
 */
public class _0015_threeSum {
    public static void main(String[] args) {
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        System.out.println(threeSum(nums));
    }

    /**
     * a + b + c = 0
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序，有序数组
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 优化：如果当前数字大于0，则三数之和一定大于0，结束循环
            if (nums[i] > 0) {
                continue;
            }
            // 去重：如果当前数字与前一个数字相同，则跳过（有序）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 去重：如果当前数字与前一个数字相同，则跳过(有序)
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去重：如果当前数字与后一个数字相同，则跳过（有序）
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 找到一个满足条件的三元组，将其添加到结果列表中
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    resList.add(triplet);
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 如果三数之和小于0，则需要将左指针向右移动，以增大三数之和
                    left++;
                } else {
                    // 如果三数之和大于0，则需要将右指针向左移动，以减小三数之和
                    right--;
                }
            }
        }

        return resList;
    }
}
