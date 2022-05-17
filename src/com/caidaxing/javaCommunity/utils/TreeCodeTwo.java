package com.caidaxing.javaCommunity.utils;

import com.caidaxing.javaCommunity.common.TreeNode;

import java.util.*;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/05/17/13:31
 * @Description:  非递归二叉树的前中后序遍历。
 */
public class TreeCodeTwo {
    /**
     * 前序遍历（非递归）
     * @param root 二叉树
     */
    public  void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        // 栈存入根结点
        stack.add(root);

        int num = 0;
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            //行首尾不得有多余空格
            if (num == 0){
                System.out.print(tmp.val);
                num++;
            }else {
                System.out.print(" "+ tmp.val);
            }
            // 前序遍历的顺序为根左右，因为栈的结构为先进后出，只有先添加右子节点，才能保证在出栈时保证先访问到左子节点，再访问到右子节点。
            if (tmp.right != null) {
                stack.add(tmp.right);
            }
            if (tmp.left != null) {
                stack.add(tmp.left);
            }
        }
    }

    /**
     * 递归中序遍历
     * @param root 二叉树
     */
    public void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        int num = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            }else {
                TreeNode tmp = stack.pop();
                //行首尾不得有多余空格
                if (num == 0){
                    System.out.print(tmp.val);
                    num++;
                }else {
                    System.out.print(" "+ tmp.val);
                }
                root = tmp.right;
            }
        }
    }

    /**
     * 递归后序遍历
     * @param root 二叉树
     */
    public void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(16);
        if (root == null) {
            return;
        }
        int num = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                map.put(root.val, 1);
                root = root.left;
            }else {
                root = stack.peek();
                if (map.get(root.val) == 2) {
                    stack.pop();
                    //行首尾不得有多余空格
                    if (num == 0) {
                        System.out.print(root.val);
                        num++;
                    } else {
                        System.out.print(" " + root.val);
                    }
                    root = null;
                }else {
                    map.put(root.val, 2);
                    root = root.right;
                }
            }
        }
    }
}
