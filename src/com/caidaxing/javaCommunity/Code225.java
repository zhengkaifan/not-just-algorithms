package com.caidaxing.javaCommunity;

import com.caidaxing.javaCommunity.common.MyStack;

/**
 * @Author: caidaxing
 * @Date: 2022/04/18/22:38
 * @Description:
 */
public class Code225 {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(12);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
