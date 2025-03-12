package com.wyd.algorithm.list;

/**
  *@Author: wyd
  * @Description: 移除链表元素 https://leetcode.cn/problems/remove-linked-list-elements/
  *@Date: 2025/3/12
  */
public class _0203_removeElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);

//        System.out.println(head);
        ListNode listNode = removeElements(head, 1);
        if (listNode != null) {
            System.out.println(listNode.val);
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead.next;
        ListNode pre = dummyHead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
