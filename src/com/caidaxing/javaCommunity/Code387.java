package com.caidaxing.javaCommunity;

import java.util.*;

/**
 * @Author: caidaxing
 * @Date: 2022/05/09/19:17
 * @Description:  字符串中的第一个唯一字符
 */
public class Code387 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println("s = " + s + "\n" + new Solution387().firstUniqChar(s));
        s = "loveleetcode";
        System.out.println("s = " + s + "\n" + new Solution387().firstUniqChar(s));
        s = "aabb";
        System.out.println("s = " + s + "\n" + new Solution387().firstUniqChar(s));
    }

}

class Solution387 {

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n; ++i) {
            if (!count.containsKey(ch[i])) {
                count.put(ch[i], i);
                queue.offer(new Pair(ch[i], i));
            } else {
                count.put(ch[i], -1);
                while (!queue.isEmpty() && count.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

}
