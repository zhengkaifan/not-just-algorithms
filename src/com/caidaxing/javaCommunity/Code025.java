package com.caidaxing.javaCommunity;

/**
 * @Author: caidaxing
 * @Date: 2022/03/30/23:14
 * @Description: 反转链表
 */
class ListNode025 {
    int val;
    ListNode025 next;
    ListNode025() {}
    ListNode025(int val) { this.val = val; }
    ListNode025(int val, ListNode025 next) { this.val = val; this.next = next; }
}

class Solution025 {
    public ListNode025 mergeTwoLists(ListNode025 l1, ListNode025 l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode025 dummyHead = new ListNode025(0);
        ListNode025 cur = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
        }
        if(l2 != null) {
            cur.next = l2;
        }
        return dummyHead.next;
    }
}

public class Code025 {

    public static void main(String[] args) {
        ListNode025 headA = parseListNode(new int[]{1, 2, 4});
        System.out.println(toString(headA));
        ListNode025 headB = parseListNode(new int[]{1, 3, 4});
        System.out.println(toString(headB));
        ListNode025 result = new Solution025().mergeTwoLists(headA, headB);
        System.out.println(toString(result));
    }

    private static ListNode025 parseListNode(int[] values) {
        ListNode025 head = null;
        ListNode025 tail = null;
        for (int value : values) {
            ListNode025 node = new ListNode025(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode025 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode025 c = h;
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
