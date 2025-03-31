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
        int[] arr = {1,3,1,2,0,5};
        System.out.println((Arrays.toString(maxSlidingWindow(arr, 3))));
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

    /**
     * 用一个单调队列来存储对应的下标
     *
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
