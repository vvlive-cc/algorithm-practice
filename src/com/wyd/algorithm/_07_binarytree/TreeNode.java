package com.wyd.algorithm._07_binarytree;

/**
 * @Author: wyd
 * @Description: 二叉树节点
 * @Date: 2025/4/9
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}