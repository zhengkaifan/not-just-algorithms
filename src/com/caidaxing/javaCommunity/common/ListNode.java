package com.caidaxing.javaCommunity.common;


/**
 * @Author: caidaxing
 * @Date: 2022/04/11/13:57
 * @Description: 构造链表对象
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
