package com.wyd.algorithm._06_stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wyd
 * @Description: 滑动窗口最大值
 * @Date: 2025/3/24
 */
public class _0239_maxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println((Arrays.toString(maxSlidingWindow(arr, 1))));
    }

    /**
     * 超出时间
     */
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int left = 0, right = 0;
//        int[] res = new int[nums.length - k + 1];
//        int index = 0;
//
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int num : nums) {
//            priorityQueue.add(num);
//            right++;
//
//            if (right - left == k) {
//                res[index++] = priorityQueue.peek();
//                priorityQueue.remove(nums[left]);
//                left++;
//            }
//        }
//
//        return res;
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;


        return res;
    }
}
