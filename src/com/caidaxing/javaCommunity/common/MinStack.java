package com.caidaxing.javaCommunity.common;

import java.util.Stack;

/**
 * @Author: caidaxing
 * @Date: 2022/04/24/20:40
 * @Description: 最小栈
 */
public class MinStack {

    // 存放元素，最小元素
    Stack<Integer> stack, minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        // 最小元素栈无元素 或者 栈顶元素大于等于 要插入的值
        if(minStack.empty()|| minStack.peek() >= val) {
            minStack.add(val);
        }
    }

    public void pop() {
        if(stack.empty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        if(stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if(stack.empty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.empty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return minStack.peek();
    }
}
