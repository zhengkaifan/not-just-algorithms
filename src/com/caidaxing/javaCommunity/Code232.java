package com.caidaxing.javaCommunity;

import com.caidaxing.javaCommunity.common.MyQueue;
import com.caidaxing.javaCommunity.common.MyStack;

/**
 * @Author: caidaxing
 * @Date: 2022/04/21/20:51
 * @Description:
 */
public class Code232 {

    public static void main(String[] args) {

        MyQueue obj = new MyQueue();
        obj.push(12);
        obj.push(13);
        obj.push(14);
        System.out.println(obj.toString());
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
