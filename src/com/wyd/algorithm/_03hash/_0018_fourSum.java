package com.wyd.algorithm._03hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wyd
 * @Description: 四数之和
 * @Date: 2025/3/17
 */
public class _0018_fourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序，有序数组
        Arrays.sort(nums);
        ArrayList<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            // 剪枝去重
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 三数之和逻辑，（双指针）
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 剪枝去重
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        // 剪枝去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        resList.add(list);
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }
        }

        return resList;
    }
}
