package com.caidaxing.javaCommunity;

import com.caidaxing.javaCommunity.common.ListNode;
import com.caidaxing.javaCommunity.utils.LinkedCode;

import java.util.Arrays;

/**
 * @Author: caidaxing
 * @Date: 2022/04/11/14:06
 * @Description: 第五天 从尾到头打印链表
 */
public class Code06 {
    public static void main(String[] args) {
        ListNode headA = LinkedCode.parseListNode(new int[]{1, 3, 2});
        System.out.println(LinkedCode.toString(headA));
        int[] reversePrint = new Solution06().reversePrint(headA);
        System.out.println(Arrays.toString(reversePrint));
    }
}
class Solution06 {
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode node1 = head, node2 = head;
        //计算长度
        while(node1 != null) {
            len ++;
            node1 = node1.next;
        }
        int[] result = new int[len];
        //倒序保存
        for(int i = len - 1; i >= 0; i --) {
            result[i] = node2.val;
            node2 = node2.next;
        }
        return result;
    }
}
