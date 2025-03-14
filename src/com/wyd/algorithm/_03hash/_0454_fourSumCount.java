package com.wyd.algorithm._03hash;

import java.util.*;

/**
 * @Author: wyd
 * @Description: 四数相加2 https://leetcode.cn/problems/4sum-ii/description/
 * @Date: 2025/3/14
 */
public class _0454_fourSumCount {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                hashMap.put(num1 + num2, hashMap.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        int res = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (hashMap.containsKey(-(num3 + num4))) {
                    res += hashMap.get(-(num3 + num4));
                }
            }
        }

        return res;
    }
}
