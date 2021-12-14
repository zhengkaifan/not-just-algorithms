package com.caidaxing.labuladong.linked_list;

/**
 * @Author: caidaxing
 * @Date: 2021/12/14/23:08
 * @Description: 相交链表 160
 */
class ListNode160 {
    int val;
    ListNode160 next;
    ListNode160(int x) {
        val = x;
        next = null;
    }
}

// @solution-sync:begin

class Solution160 {
    public ListNode160 getIntersectionNode(ListNode160 headA, ListNode160 headB) {
        // p1 指向 headA 头结点， p2 指向 headB 头结点
        ListNode160 p1 = headA, p2 = headB;
        int len_p1 = 0, len_p2 = 0;
        // 记录两个链表的长度
        while (p1.next != null) {
            p1 = p1.next;
            len_p1 ++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            len_p2 ++;
        }
        p1 = headA;
        p2 = headB;
        // 让 p 和 q 到达尾部的距离相同
        if(len_p2 >= len_p1) {
            for (int i = 0; i < len_p2 - len_p1; i++) {
                p2 = p2.next;
            }
        }else {
            for (int i = 0; i < len_p1 - len_p2; i++) {
                p1 = p1.next;
            }
        }
        // 看两个指针是否会相同，p == q 时有两种情况：
        // 要么是两条链表不相交，他俩同时走到尾部空指针
        // 要么是两条链表相交，他俩走到两条链表的相交点
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
// @solution-sync:end

class Code160 {

    public static void main(String[] args) {
        ListNode160 headA = parseListNode160(new int[]{4, 1, 8, 4, 5});
        ListNode160 headB = parseListNode160(new int[]{5, 6, 1, 8, 4, 5});

        ListNode160 result = new Solution160().getIntersectionNode(headA, headB);
        System.out.println(toString(result));
    }

    private static ListNode160 parseListNode160(int[] values) {
        ListNode160 head = null;
        ListNode160 tail = null;
        for (int value : values) {
            ListNode160 node = new ListNode160(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode160 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode160 c = h;
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

