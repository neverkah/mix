package com.algorithm.validateBinarySearchTree;

/**
 * leetcode 98 验证二叉搜索树
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isIn(int dest, Integer min, Integer max) {
        if (min != null && dest <= min) {
            return false;
        }
        if (max != null && dest >= max) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (!isIn(root.val, min, max)) {
            return false;
        }
        if ((null != root.left && !isValidBST(root.left, min, root.val)) || (null != root.right && !isValidBST(root.right, root.val, max))) {
            return false;
        }
        return true;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
