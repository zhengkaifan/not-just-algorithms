package com.caidaxing.javaCommunity;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: caidaxing
 * @Date: 2022/05/06/13:08
 * @Description: 有效的括号
 */
public class Code20 {

    public static void main(String[] args) {
        String s = "(";
        System.out.println(new Solution20().isValid(s));
        s = "()[]{}";
        System.out.println(new Solution20().isValid(s));
        s = "(]";
        System.out.println(new Solution20().isValid(s));
        s = "([)]";
        System.out.println(new Solution20().isValid(s));
        s = "{[]}";
        System.out.println(new Solution20().isValid(s));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for(char ch : chars) {
            boolean left = ch == '(' || ch == '[' || ch == '{';
            if(left) {
                q.push(ch);
            }else if(q.isEmpty() || !match (q.pop(), ch)){
                return false;
            }
        }
        return q.isEmpty();
    }

    public boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '[' && r == ']') || (l == '{' && r == '}') ;
    }
}