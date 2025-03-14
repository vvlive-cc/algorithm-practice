package com.wyd.algorithm._03hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: wyd
 * @Description: 两个数组的交集 https://leetcode.cn/problems/intersection-of-two-arrays/description/
 * @Date: 2025/3/14
 */
public class _0349_intersection {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        // 将 HashSet 转换为 int[]
        int[] result = new int[res.size()];
        int index = 0;
        for (int num : res) {
            result[index++] = num;
        }
        return result;
    }
}
