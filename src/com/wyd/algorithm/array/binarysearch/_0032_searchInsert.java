package com.wyd.algorithm.array.binarysearch;

/**
 * @Author: wyd
 * @Description: 搜索插入位置 https://leetcode.cn/problems/search-insert-position/
 * @Date: 2025/3/11
 */
public class _0032_searchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 为什么直接return left；因为如果上面的没有返回return middle，
        // 说明最后一定是，left>right从而跳出循环的，在此之前是left=right，
        // 如果最后是right-1导致的left>right，说明原来的right位置是大于target的，所以返回原来的right位置即left位置；
        // 如果最后是left+1导致的left>right,说明是原来的的left=right这个位置小于target，
        // 而right能移动到这个位置，说明此位置右侧是大于target的，left现在加1就移动到了这样的位置，返回left即可
        return left;
    }
}
