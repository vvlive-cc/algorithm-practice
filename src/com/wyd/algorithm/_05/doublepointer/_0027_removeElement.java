package com.wyd.algorithm._05.doublepointer;

/**
 * @Author: wyd
 * @Description: 移除元素
 * @Date: 2025/3/20
 */
public class _0027_removeElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
