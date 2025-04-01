package com.wyd.algorithm._06_stackqueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: wyd
 * @Description: 前K个高频元素
 * @Date: 2025/3/31
 */
public class _0347_topKFrequent {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

//    /**
//     * 哈希 排序
//     * @param nums
//     * @param k
//     * @return
//     */
//    public static int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
//        }
//        int[] array = hashMap.entrySet()
//                .stream().
//                sorted((o1, o2) -> o2.getValue() - o1.getValue())
//                .map(Map.Entry::getKey)
//                .mapToInt(Integer::intValue)
//                .toArray();
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = array[i];
//        }
//        return res;
//    }

    /**
     * 哈希 优先级队列
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((map1, map2) -> map1.getValue() - map2.getValue());
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry);
            } else {
                priorityQueue.offer(entry);
                priorityQueue.poll();
            }
        }

        return priorityQueue.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }
}

