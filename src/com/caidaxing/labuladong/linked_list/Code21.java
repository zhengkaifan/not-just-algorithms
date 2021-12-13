package com.caidaxing.labuladong.linked_list;

/**
 * @Author: caidaxing
 * @Date: 2021/12/13/17:02
 * @Description: 合并两个有序列表 21
 */
class ListNode21 {
    int val;
    ListNode21 next;
    ListNode21() {}
    ListNode21(int val) { this.val = val; }
    ListNode21(int val, ListNode21 next) { this.val = val; this.next = next; }
}

// @solution-sync:begin

class Solution21 {
    public ListNode21 mergeTwoLists(ListNode21 list1, ListNode21 list2) {
        // 虚拟头结点
        ListNode21 dumpy = new ListNode21(-1), p = dumpy;
        ListNode21 p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            // p1、p2 比较
            // 将值较小的结点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if(p2 != null) {
            p.next = p2;
        }
        return dumpy.next;
    }
}
// @solution-sync:end

/**
 * 测试运行代码
 * @author caidaxing
 */
public class Code21 {
    public static void main(String[] args) {
        ListNode21 list1 = parseListNode(new int[]{1, 2, 4});
        ListNode21 list2 = parseListNode(new int[]{1, 3, 4});

        ListNode21 result = new Solution21().mergeTwoLists(list1, list2);
        System.out.println(toString(result));
    }

    private static ListNode21 parseListNode(int[] values) {
        ListNode21 head = null;
        ListNode21 tail = null;
        for (int value : values) {
            ListNode21 node = new ListNode21(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode21 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode21 c = h;
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

