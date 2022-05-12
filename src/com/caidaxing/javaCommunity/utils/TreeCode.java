package com.caidaxing.javaCommunity.utils;

import com.caidaxing.javaCommunity.common.TreeNode;

/**
 * @Author: caidaxing
 * @Date: 2022/05/12/16:29
 * @Description: 实现二叉树的递归的前中后序遍历
 */
public class TreeCode {

    /**
     * 递归前序遍历
     * @param root 二叉树
     */
    public  void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 递归中序遍历
     * @param root 二叉树
     */
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    /**
     * 递归后序遍历
     * @param root 二叉树
     */
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }
}
