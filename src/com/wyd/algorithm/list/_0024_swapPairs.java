package com.wyd.algorithm.list;

/**
 * @Author: wyd
 * @Description: 两两交换节点
 * @Date: 2025/3/13
 */
public class _0024_swapPairs {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode().buildListNode(arr);
        swapPairs(head).print();
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode res = cur.next;
        while (next != null) {
            cur.next = next.next;
            next.next = cur;
            if (pre != null) {
                pre.next = next;
            }

            pre = cur;
            cur = cur.next;
            next = cur == null ? null : cur.next;
        }
        return res;
    }
}
