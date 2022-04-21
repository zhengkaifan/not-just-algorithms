package com.caidaxing.javaCommunity.common;

import java.util.Stack;

/**
 * @Author: caidaxing
 * @Date: 2022/04/21/20:49
 * @Description:  用栈实现队列
 */
public class MyQueue {

    // 两个栈 分别进栈，出栈
    Stack<Integer> stack1, stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 栈与队列 插入操作都是限定在表尾进行
    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        // 反转 如果stack2为空，那么将stack1中的元素全部放到stack2中
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        // 反转 如果stack2为空，那么将stack1中的元素全部放到stack2中
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
