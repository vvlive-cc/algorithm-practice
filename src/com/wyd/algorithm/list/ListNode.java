package com.wyd.algorithm.list;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        List<Integer> list = new ArrayList<>();
        list.add(val);
        while (next != null) {
            list.add(next.val);
            next = next.next;
        }
        System.out.println(list.toString());
    }

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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
