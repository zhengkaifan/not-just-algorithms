package com.caidaxing.labuladong.linked_list;

import java.util.PriorityQueue;

/**
 * @Author: caidaxing
 * @Date: 2021/12/13/21:41
 * @Description: 合并 K 个升序链表 23
 */
class ListNode23 {
    int val;
    ListNode23 next;
    ListNode23() {}
    ListNode23(int val) { this.val = val; }
    ListNode23(int val, ListNode23 next) { this.val = val; this.next = next; }
}

// @solution-sync:begin

class Solution23 {
    public ListNode23 mergeKLists(ListNode23[] lists) {
        if(lists.length == 0) {
            return null;
        }
        // 虚拟头结点
        ListNode23 dumpy = new ListNode23(-1), p = dumpy;
        // 优先级队列，最小堆 每次获得 k 个节点中的最小节点
        PriorityQueue<ListNode23> pq = new PriorityQueue<ListNode23>(
                lists.length, (a, b) -> (a.val - b.val)
        );
        // 将 k 个链表的头结点加入最小堆
        for(ListNode23 node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }
        // 最小堆仍有元素
        while(!pq.isEmpty()) {
            // 获取最小结点，接到结果链表中
            ListNode23 temp = pq.poll();
            p.next = temp;
            if(temp.next != null) {
                pq.add(temp.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dumpy.next;
    }
}
// @solution-sync:end

/**
 * 测试运行代码
 * @author caidaxing
 */
public class Code23 {
    public static void main(String[] args) {
        ListNode23[] lists = new ListNode23[]{
                parseListNode(new int[]{1, 4, 5}),
                parseListNode(new int[]{1, 3, 4}),
                parseListNode(new int[]{2, 6})
        };

        ListNode23 result = new Solution23().mergeKLists(lists);
        System.out.println(toString(result));
    }

    private static ListNode23 parseListNode(int[] values) {
        ListNode23 head = null;
        ListNode23 tail = null;
        for (int value : values) {
            ListNode23 node = new ListNode23(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode23 h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode23 c = h;
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
