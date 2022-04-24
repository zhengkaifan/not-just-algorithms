package com.caidaxing.javaCommunity;

import com.caidaxing.javaCommunity.common.MinStack;

/**
 * @Author: caidaxing
 * @Date: 2022/04/24/20:41
 * @Description:
 */
public class Code155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println("返回最小值：" + min);
        minStack.pop();
        int top = minStack.top();
        System.out.println("返回栈顶值：" + top);
        min = minStack.getMin();
        System.out.println("返回最小值：" + min);
    }
}
