package com.caidaxing.labuladong.linked_list;

/**
 * @Author: caidaxing
 * @Date: 2021/12/14/22:49
 * @Description: 环形链表 Ⅱ 142
 */
class ListNode142 {
    int val;
    ListNode142 next;
    ListNode142(int x) {
        val = x;
        next = null;
    }
}

// @solution-sync:begin

class Solution142 {
    public ListNode142 detectCycle(ListNode142 head) {
        // 快慢指针初始化指向 head
        ListNode142 p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            // 出现相遇，说明成环了
            if(p1 == p2) {
                break;
            }
        }
        // 快指针遇到空指针说明没有环
        if(p2 == null || p2.next == null) {
            return null;
        }
        // 重新指向 head
        p1 = head;
        // 重新同步前进，相遇就是环起点
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
// @solution-sync:end

class Code142 {

    public static void main(String[] args) {
        ListNode142 head = parseListNode142(new int[]{3, 2, 0, -4});

        ListNode142 result = new Solution142().detectCycle(head);
        System.out.println(toString(result));
    }

    private static ListNode142 parseListNode142(int[] values) {
        ListNode142 head = null;
        ListNode142 tail = null;
        for (int value : values) {
            ListNode142 node = new ListNode142(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode142 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode142 c = h;
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

