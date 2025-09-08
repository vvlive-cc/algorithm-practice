package com.wyd.algorithm.labuladong.core;

import com.wyd.algorithm.struct.ListNode;

import java.util.ArrayList;

/**
 * 双指针：<a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/"/>
 */
public class DoublePointerList {

    /**
     * 141. 环形链表；<a href="https://leetcode.cn/problems/linked-list-cycle/"/>
     * 快慢指针：快指针每次移动两步，慢指针每次移动一步，如果有环，快慢指针会相遇
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    /**
     * 142. 环形链表 II：<a href="https://leetcode.cn/problems/linked-list-cycle-ii/"/>
     * 题解：<a href="https://leetcode.cn/problems/linked-list-cycle-ii/solutions/1999271/mei-xiang-ming-bai-yi-ge-shi-pin-jiang-t-nvsq/"/>
     * 快慢指针：快指针每次移动两步，慢指针每次移动一步，如果有环，快慢指针会相遇
     * 获取环的入口：
     * 头节点到环入口的距离为 a，环入口到相遇点距离为 b，相遇点到环入口距离设为 c
     * 慢指针行走距离为 a + b，快指针行走距离为 a + b + k(b + c)
     * 快指针是慢指针2倍
     * => 2(a + b) = a + b + k(b + c)
     * => 2a + 2b = a + b + b + c + (k - 1)(b + c)
     * => a - c = (k - 1)(b + c)
     * => a = (k - 1)(b + c) + c
     * 相遇之后，慢指针回到头节点出发，快慢指针同时开始移动，相遇的点就是环的入口点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 获取环的入口点
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 160. 相交链表：<a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/"/>
     * 描述：给定两个单链表的头节点 headA 和 headB ，返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * 思路:
     * headA 长度 a， headB 长度 b ，headA 和 headB 的相交长度 c
     * 相交之前的长度分别是 a - c 和 b - c
     * a + （b - c） = b + （a - c）
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        // 先遍历一个链表，然后再遍历另一个链表，直到两个指针相遇
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    /**
     * 19. 删除链表的倒数第 N 个结点：<a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/"/>
     * 思路：
     * 快慢指针，快指针先移动 n 步，然后快慢指针同时移动，当快指针到达末尾时，慢指针指向的节点就是倒数第 n 个节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个虚拟节点，方便处理
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针先移动 n 步
        while (n-- > 0) {
            fast = fast.next;
        }
        // 快慢指针同时移动
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 当快指针移动到末尾，慢指针在倒数 n + 1 个位置，删除倒数第 n 个节点
        slow.next = slow.next.next;
        return dummy.next;
    }


    /**
     * 21. 合并两个有序链表：<a href="https://leetcode.cn/problems/merge-two-sorted-lists/"/>
     * 描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 思路：
     * 创建一个虚拟节点，然后比较两个链表的节点值，将较小的节点插入到虚拟节点后面
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 遍历 list1 lit2，取最小的节点添加到 dummy
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    /**
     * 0023 合并 k 个升序链表 <a href="https://leetcode.cn/problems/merge-k-sorted-lists/"/>
     * 描述：给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 思路: 利用合并两个升序链表的方法，将 k 个链表两两合并，最终得到一个升序链表（归并排序）
     * 时间复杂度：O(nlogk)
     * 空间复杂度：O(1)
     *
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            ArrayList<ListNode> tempList = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                tempList.add(mergeTwoLists(lists[i], i + 1 < lists.length ? lists[i + 1] : null));
            }
            lists = tempList.toArray(new ListNode[]{});
        }
        return lists[0];
    }

    /**
     * 86. 分隔链表：<a href="https://leetcode.cn/problems/partition-list/"/>
     * 描述：给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * 思路：
     * 创建两个虚拟节点，一个节点小于 x，一个节点大于等于 x，然后遍历链表，将节点插入到对应的虚拟节点后面
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     **/
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }

    /**
     * 876. 链表的中间结点：<a href="https://leetcode.cn/problems/middle-of-the-linked-list/"/>
     * 描述：给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 思路：
     * 快慢指针，快指针每次移动两步，慢指针每次移动一步，当快指针到达末尾时，慢指针指向的节点就是中间节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 链表训练：<a href="https://leetcode.cn/problems/training-plan/"/>
     * 描述：给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
     * 思路：
     * 快慢指针，快指针先移动 cnt 步，然后快慢指针同时移动，当快指针到达末尾时，慢指针指向的节点就是倒数第 cnt 个节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * */
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode slow = head;
        ListNode fast = head;

        while (cnt-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode().buildListNode(new int[]{1});
//        ListNode node2 = new ListNode().buildListNode(new int[]{1, 3, 4});
//        ListNode node3 = new ListNode().buildListNode(new int[]{2, 6});
        System.out.println(new DoublePointerList().mergeKLists(new ListNode[]{node1}));
    }
}
