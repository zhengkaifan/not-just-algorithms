package com.caidaxing.labuladong.linked_list;

/**
 * @Author: caidaxing
 * @Date: 2021/12/13/23:08
 * @Description: 删除倒数链表的第 N 个结点 19
 */
class ListNode19 {
    int val;
    ListNode19 next;
    ListNode19() {}
    ListNode19(int val) { this.val = val; }
    ListNode19(int val, ListNode19 next) { this.val = val; this.next = next; }
}

// @Solution19-sync:begin

class Solution19 {
    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        // 虚拟头结点
        ListNode19 dumpy = new ListNode19(-1);
        dumpy.next = head;
        // 要删除第 N 个结点，要先找到第 (N + 1) 个结点
        ListNode19 temp = findFromEnd(dumpy, n + 1);
        // 删除倒数第 N 个结点
        temp.next = temp.next.next;
        return dumpy.next;
    }

    private ListNode19 findFromEnd(ListNode19 head, int k) {
        ListNode19 p1 = head;
        // p1 先走 n 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode19 p2 = head;
        // p1 、p2 同时走 (n - k) 步
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 现在 p2 指向第 (n - k) 个结点
        return p2;
    }
}
// @solution-sync:end

/**
 * 测试运行代码
 * @author caidaxing
 */
public class Code19 {

    public static void main(String[] args) {
        ListNode19 head = parseListNode(new int[]{1, 2, 3, 4, 5});
        int n = 2;

        ListNode19 result = new Solution19().removeNthFromEnd(head, n);
        System.out.println(toString(result));
    }

    private static ListNode19 parseListNode(int[] values) {
        ListNode19 head = null;
        ListNode19 tail = null;
        for (int value : values) {
            ListNode19 node = new ListNode19(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode19 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode19 c = h;
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
