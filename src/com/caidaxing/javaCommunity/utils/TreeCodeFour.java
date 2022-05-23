package com.caidaxing.javaCommunity.utils;



import com.caidaxing.javaCommunity.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/05/23/23:27
 * @Description: 107. 二叉树的层序遍历 II
 */
public class TreeCodeFour {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        //队列存入根节点
        q.add(root);
        while (!q.isEmpty()){
            // 每一层的数目
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0) {
                TreeNode tmp = q.poll();
                list.add(tmp.val);
                //再存入根节点的两个左右子节点（如果存在）
                //达到每一层的节点都连续在一块
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
                count --;
            }
            /* 第一种方法：尾部插入，最后反转 res.add(list); */
            /* 第二种方法：头部插入 在开头添加元素*/
            res.add(0, list);
        }
        /* Collections.reverse(res);*/
        return res;
    }
}
