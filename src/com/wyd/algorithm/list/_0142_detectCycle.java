package com.wyd.algorithm.list;

import java.util.HashSet;

/**
 * @Author: wyd
 * @Description: 环形链表2 https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * @Date: 2025/3/13
 */
public class _0142_detectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = head;

        detectCycle(head).print();
    }

    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (hashSet.contains(curr)) {
                return curr;
            }
            hashSet.add(curr);
            curr = curr.next;
        }
        return null;
    }

    // todo 快慢指针
}
