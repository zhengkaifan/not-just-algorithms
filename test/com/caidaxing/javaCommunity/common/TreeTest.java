package com.caidaxing.javaCommunity.common;

import com.caidaxing.javaCommunity.utils.TreeCode;

import java.util.Scanner;

/**
 * @Author: caidaxing
 * @Date: 2022/05/12/16:35
 * @Description:
 */
public class TreeTest {

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    static TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] post = new int[N];
        int[] in = new int[N];
        //后序遍历
        System.out.print("输入要构建的二叉树的后序遍历：");
        for (int i = 0; i < N; i++) {
            post[i] = sc.nextInt();
        }
        //终须遍历
        System.out.print("输入要构建的二叉树的中序遍历：");
        for (int i = 0; i < N; i++) {
            in[i] = sc.nextInt();
        }
        //构造二叉树
        TreeNode node = buildTree(in, post);
        System.out.println();
        System.out.print("构建成功的二叉树的前序遍历：");
        new TreeCode().preOrderTraversal(node);
        System.out.println();
        System.out.print("构建成功的二叉树的中序遍历：");
        new TreeCode().inOrderTraversal(node);
        System.out.println();
        System.out.print("构建成功的二叉树的后序遍历：");
        new TreeCode().postOrderTraversal(node);
        System.out.println();
    }

}
