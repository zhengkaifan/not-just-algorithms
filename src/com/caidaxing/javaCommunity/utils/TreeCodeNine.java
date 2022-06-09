package com.caidaxing.javaCommunity.utils;

import com.caidaxing.javaCommunity.common.TreeNode;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/09/15:47
 * @Description: 112. 路径总和
 */
public class TreeCodeNine {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        // 叶子节点：其没有左右字节点，均为null
        if(root.left == root.right) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
