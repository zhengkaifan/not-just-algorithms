package com.caidaxing.javaCommunity.utils;

import com.caidaxing.javaCommunity.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/05/26/18:39
 * @Description: 637. 二叉树的层平均值
 */
public class TreeCodeFive {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        //队列存入根节点
        q.add(root);
        while (!q.isEmpty()){
            // 每一层的数目
            int count = q.size();
            double sum = 0.0;
            for(int i = 0; i < count; i ++) {
                TreeNode tmp = q.poll();
                sum += tmp.val;
                //再存入根节点的两个左右子节点（如果存在）
                //达到每一层的节点都连续在一块
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            // 记录当前行的平均值
            res.add(sum / count);
        }
        return res;
    }

}
