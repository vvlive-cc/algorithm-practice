package com.wyd.algorithm._05.doublepointer;

import com.wyd.algorithm.list.ListNode;

/**
 * @Author: wyd
 * @Description: 删除链表的倒数第N个节点 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * @Date: 2025/3/13
 */
public class _0019_removeNthFromEnd {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode().buildListNode(arr);
        removeNthFromEnd(head, 2).print();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode curr = head;
        ListNode pre = dummyHead;

        // 间隔 n 个节点
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        // 移动 curr 到链表末尾, pre 移动到待删除节点的前一个节点
        while (curr != null) {
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return dummyHead.next;
    }
}
