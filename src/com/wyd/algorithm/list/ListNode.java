package com.wyd.algorithm.list;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void print() {
        List<Integer> list = new ArrayList<>();
        list.add(val);
        while (next != null) {
            list.add(next.val);
            next = next.next;
        }
        System.out.println(list.toString());
    }
}
