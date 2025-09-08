package com.wyd.algorithm.struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }


    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 构建链表
     *
     * @param arr 数组
     * @return 链表头结点
     */
    public ListNode buildListNode(int[] arr) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                cur.val = arr[i];
            } else {
                ListNode node = new ListNode(arr[i]);
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }

    /**
     * 构建链表: 环状链表
     *
     * @param arr 数组
     * @param pos 链表环的起始位置
     * @return 链表头结点
     */
    public ListNode buildListNode(int[] arr, int pos) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                cur.val = arr[i];
            } else {
                ListNode node = new ListNode(arr[i]);
                cur.next = node;
                cur = node;
            }
        }

        if (pos != -1) {
            ListNode node = head;
            for (int i = 0; i < pos; i++) {
                node = node.next;
            }
            cur.next = node;
        }

        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
//                ", next=" + next +
                '}';
    }
}
