package com.caidaxing.javaCommunity;

import com.caidaxing.javaCommunity.common.ListNode;
import com.caidaxing.javaCommunity.utils.LinkedCode;

import java.util.Arrays;

/**
 * @Author: caidaxing
 * @Date: 2022/04/13/16:54
 * @Description: 环形链表
 */
public class Code141 {

    public static void main(String[] args) {
        ListNode headA = LinkedCode.parseListNode(new int[]{3, 2, 0, -4});
        System.out.println(LinkedCode.toString(headA));
        //链表的实际情况未考虑
        boolean res = new Solution141().hasCycle(headA);
        System.out.println(res);
    }


}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        //快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //快慢指针相遇，成环了
            while (slow == fast) {
                return true;
            }
        }
        //不成环
        return false;
    }
}