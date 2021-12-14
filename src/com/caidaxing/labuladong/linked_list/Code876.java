package com.caidaxing.labuladong.linked_list;

/**
 * @Author: caidaxing
 * @Date: 2021/12/14/16:46
 * @Description: 链表的中间结点 876
 */
public class Code876 {
    public static void main(String[] args) {
        ListNode876 head = parseListNode876(new int[]{1, 2, 3, 4, 5});

        ListNode876 result = new Solution876().middleNode(head);
        System.out.println(toString(result));
    }

    private static ListNode876 parseListNode876(int[] values) {
        ListNode876 head = null;
        ListNode876 tail = null;
        for (int value : values) {
            ListNode876 node = new ListNode876(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode876 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode876 c = h;
        while (c != null) {
            buf.append(c.val);
            if (c.next != null) {
                buf.append(",");
            }
            c = c.next;
        }
        buf.append("]");
        return buf.toString();
    }

}

class ListNode876 {
    int val;
    ListNode876 next;
    ListNode876() {}
    ListNode876(int val) { this.val = val; }
    ListNode876(int val, ListNode876 next) { this.val = val; this.next = next; }
}

// @solution-sync:begin

class Solution876 {
    public ListNode876 middleNode(ListNode876 head) {
        // 快慢指针初始化指向 head
        ListNode876 p1 = head, p2 = head;
        // p2 走到末尾时停止
        while (p2 != null && p2.next != null) {
            // p1 走一步，p2 走两步
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 此时 p1 走到中点
        return p1;
    }
}