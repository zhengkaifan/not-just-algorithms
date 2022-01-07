package com.caidaxing.labuladong.linked_list;

/**
 * @Author: caidaxing
 * @Date: 2022/01/05/0:08
 * @Description:
 */
class ListNode234 {
    int val;
    ListNode234 next;
    ListNode234() {}
    ListNode234(int val) { this.val = val; }
    ListNode234(int val, ListNode234 next) { this.val = val; this.next = next; }
}

// @solution-sync:begin

class Solution234 {
    ListNode234 left;
    public boolean isPalindrome(ListNode234 head) {
        left = head;
        return traverse(head);
    }
    boolean traverse(ListNode234 right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        // 后序遍历
        res = res && (right.val == left.val);
        left =  left.next;
        return res;

    }
}
// @solution-sync:end

class Code234 {

    public static void main(String[] args) {
        ListNode234 head = parseListNode234(new int[]{1, 2, 2, 1});

        boolean result = new Solution234().isPalindrome(head);
        System.out.println(result);
    }

    private static ListNode234 parseListNode234(int[] values) {
        ListNode234 head = null;
        ListNode234 tail = null;
        for (int value : values) {
            ListNode234 node = new ListNode234(value);
            if (head == null)
                head = node;
            else
                tail.next = node;
            tail = node;
        }
        return head;
    }

}
