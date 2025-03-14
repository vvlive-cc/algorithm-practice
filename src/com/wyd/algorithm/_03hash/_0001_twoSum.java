package com.wyd.algorithm._03hash;

import java.util.HashMap;

/**
 * @Author: wyd
 * @Description: 两数之和
 * @Date: 2025/3/14
 */
public class _0001_twoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashSet = new HashMap<>();
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (hashSet.containsKey(temp)) {
                return new int[]{hashSet.get(temp), i};
            } else {
                hashSet.put(nums[i], i);
            }
        }
        return null;
    }
}
