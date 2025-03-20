package com.wyd.algorithm._05.doublepointer;

import com.wyd.algorithm.list.ListNode;

/**
 * @Author: wyd
 * @Description: 相交链表 https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 * @Date: 2025/3/13
 */
public class _0160_getIntersectionNode {
    public static void main(String[] args) {
        int[] arr1 = {1,9,1,2,4};
        ListNode headA = new ListNode().buildListNode(arr1);
        int[] arr2 = {3,2,4};
        ListNode headB = new ListNode().buildListNode(arr2);
        ListNode listNode = getIntersectionNode(headA, headB);
        if (listNode == null) {
            System.out.println("null");
        } else {
            listNode.print();
        }
    }

    /**
     * headA 长度 a
     * headB 长度 b
     * 重合长度 c
     * 思路：
     * p1 走过的路径 a + (b - c)
     * p2 走过的路径 b + (a - c)
     * 两者相交，则 p1 和 p2 相遇，否则 p1 和 p2 会分别到达 null
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

}
