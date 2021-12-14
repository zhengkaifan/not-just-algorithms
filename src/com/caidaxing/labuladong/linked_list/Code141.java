package com.caidaxing.labuladong.linked_list;

/**
 * @Author: caidaxing
 * @Date: 2021/12/14/22:38
 * @Description: 环形链表 141
 */
class ListNode141 {
    int val;
    ListNode141 next;
    ListNode141(int x) {
        val = x;
        next = null;
    }
}

// @solution-sync:begin

class Solution141 {
    public boolean hasCycle(ListNode141 head) {
        // 快慢指针初始化指向 head
        ListNode141 p1 = head, p2 = head;
        while(p2 != null && p2.next != null) {
            // 慢指针走一步，快指针走两步
            p1 = p1.next;
            p2 = p2.next.next;
            // 快慢指针还能相遇，说明成环了
            while (p1 == p2) {
                return true;
            }
        }
        // 不成环
        return false;
    }
}
// @solution-sync:end

class Code141 {

    public static void main(String[] args) {
        ListNode141 head = parseListNode141(new int[]{3, 2, 0, -4});

        boolean result = new Solution141().hasCycle(head);
        System.out.println(result);
    }

    private static ListNode141 parseListNode141(int[] values) {
        ListNode141 head = null;
        ListNode141 tail = null;
        for (int value : values) {
            ListNode141 node = new ListNode141(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

}
