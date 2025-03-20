package com.wyd.algorithm._05.doublepointer;

import com.wyd.algorithm.list.ListNode;

/**
 * @Author: wyd
 * @Description: 翻转链表
 * @Date: 2025/3/12
 */
public class _0206_reverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        reverseList(head).print();
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next; // 暂存后继节点
            cur.next = pre; // 修改 next 指向
            pre = cur; // pre 指向 cur 后移
            cur = next; // cur 指向 next 后移
        }

        return pre;
    }
}
