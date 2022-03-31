package com.caidaxing.javaCommunity;

/**
 * @Author: caidaxing
 * @Date: 2022/03/30/23:14
 * @Description: 反转链表
 */
class ListNode206 {
    int val;
    ListNode206 next;
    ListNode206() {}
    ListNode206(int val) { this.val = val; }
    ListNode206(int val, ListNode206 next) { this.val = val; this.next = next; }
}

class Solution206 {
    public ListNode206 reverseList(ListNode206 head) {
        if(head == null || head.next == null) {
            return head;
        }
        //递归
        ListNode206 last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

public class Code206 {

    public static void main(String[] args) {
        ListNode206 head = parseListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(toString(head));
        ListNode206 result = new Solution206().reverseList(head);
        System.out.println(toString(result));
    }

    private static ListNode206 parseListNode(int[] values) {
        ListNode206 head = null;
        ListNode206 tail = null;
        for (int value : values) {
            ListNode206 node = new ListNode206(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode206 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode206 c = h;
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
