package com.wyd.algorithm.labuladong.core;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 双指针-数组：https://labuladong.online/algo/essential-technique/array-two-pointers-summary/
 */
public class DoublePointerArray {
    public int[] twoSum(int[] numbers, int target) { 
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            int temp = target - numbers[index];
            if (hashMap.containsKey(temp)) {
                return new int[] {hashMap.get(temp) + 1, ++index};
            } else {
                hashMap.put(numbers[index], index);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        DoublePointerArray doublePointerArray = new DoublePointerArray();
       System.out.println(doublePointerArray.twoSum(new int[]{2,7,11,15}, 9));
    }

}
