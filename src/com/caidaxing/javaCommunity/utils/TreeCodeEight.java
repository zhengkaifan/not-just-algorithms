package com.caidaxing.javaCommunity.utils;

import com.caidaxing.javaCommunity.common.TreeNode;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/06/22:54
 * @Description: 104. 二叉树的最大深度
 */
public class TreeCodeEight {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftRoot = maxDepth(root.left);
        int rightRoot = maxDepth(root.right);
        return Math.max(leftRoot, rightRoot) + 1;
    }
}
