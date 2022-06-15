package com.caidaxing.javaCommunity.utils;

import com.caidaxing.javaCommunity.common.TreeNode;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/11/19:10
 * @Description: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class TreeCodeTen {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为 null，或者两个指定节点其中一个为根节点，此时最近公共祖先即根节点
        if(root == null || root == p || root == q) {
            return root;
        }
        // 左右节点递归
        TreeNode leftTmp = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTmp = lowestCommonAncestor(root.right, p, q);
        if (leftTmp == null && rightTmp == null) {
            // p q 不存在于左右子树
            return null;
        }
        if (leftTmp == null) {
            // 当 leftTmp 为空 rightTmp 不为空, p q 都不在左子树
            return rightTmp;
        }
        if (rightTmp == null) {
            // 当 rightTmp 为空 leftTmp 不为空, p q 都不在右子树
            return leftTmp;
        }
        // 当 leftTmp rightTmp 不为空, p q 一个在左子树，一个在右子树
        return root;
    }

}
