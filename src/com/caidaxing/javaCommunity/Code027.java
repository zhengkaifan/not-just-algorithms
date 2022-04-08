package com.caidaxing.javaCommunity;

/**
 * @Author: caidaxing
 * @Date: 2022/03/30/23:14
 * @Description: 回文链表
 */
class ListNode027 {
    int val;
    ListNode027 next;
    ListNode027() {}
    ListNode027(int val) { this.val = val; }
    ListNode027(int val, ListNode027 next) { this.val = val; this.next = next; }
}

class Solution027 {
    ListNode027 left;
    public boolean isPalindrome(ListNode027 head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode027 right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        // 后序遍历
        res = res && (right.val == left.val);
        left =  left.next;
        return res;

    }
}

public class Code027 {

    public static void main(String[] args) {
        ListNode027 head = parseListNode(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(toString(head));
        boolean res = new Solution027().isPalindrome(head);
        System.out.println(res);
    }

    private static ListNode027 parseListNode(int[] values) {
        ListNode027 head = null;
        ListNode027 tail = null;
        for (int value : values) {
            ListNode027 node = new ListNode027(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode027 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode027 c = h;
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
