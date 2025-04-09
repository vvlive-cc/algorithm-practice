package com.wyd.algorithm._07_binarytree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.wyd.algorithm._07_binarytree.TreeNode;

/**
 * @Author: wyd
 * @Description: 前序遍历
 * @Date: 2025/4/9
 */
public class _0114_preorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        System.out.println(preorderTraversalByStact(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode currNode = root;
        traversal(currNode, res);
        return res;
    }

    /**
     * 递归函数 根 左 右
     * @param currNode 当前节点
     * @param res 结果集
     */
    public static void traversal(TreeNode currNode, List<Integer> res) {
        if (currNode == null) {
            return;
        }
        res.add(currNode.val);
        traversal(currNode.left, res);
        traversal(currNode.right, res);

    }


    /**
     * 迭代法
     * @param root 根节点
     * @return 结果集
     */
    public static List<Integer> preorderTraversalByStact(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        
        while (currNode != null || !stack.isEmpty()) { 
            if (currNode != null) {
                res.add(currNode.val);
                stack.add(currNode);
                currNode = currNode.left;
            } else {
                TreeNode pop = stack.pop();
                currNode = pop.right;
            }
        }
        
        return res;
    }

}
