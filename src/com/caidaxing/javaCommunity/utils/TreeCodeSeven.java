package com.caidaxing.javaCommunity.utils;

import com.caidaxing.javaCommunity.common.TreeNode;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/02/23:15
 * @Description: 28. 对称的二叉树
 */
public class TreeCodeSeven {
    public boolean isSymmetric(TreeNode root) {
        // 树为空，肯定对称
        if(root == null) {
            return true;
        }
        // 判断左右结点是否对称
        return ismirror(root.left, root.right);
    }

    public boolean ismirror(TreeNode leftRoot, TreeNode rightRoot) {
        // 两树为空，肯定对称
        if(leftRoot == null && rightRoot == null) {
            return true;
        }
        // 其中一棵树为空，或者不对称：
        if(leftRoot == null || rightRoot == null) {
            return false;
        }
        // 两树当前结点值不相等
        if(leftRoot.val != rightRoot.val) {
            return false;
        }
        // 两树结点均不为空，递归
        return ismirror(leftRoot.left, rightRoot.right) && ismirror(leftRoot.right, rightRoot.left);
    }
}
