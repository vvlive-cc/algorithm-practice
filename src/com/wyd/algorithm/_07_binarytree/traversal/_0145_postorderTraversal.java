package com.wyd.algorithm._07_binarytree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.wyd.algorithm._07_binarytree.TreeNode;

/**
 * @Author: wyd
 * @Description: 中序遍历
 * @Date: 2025/4/9
 */
public class _0145_postorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        System.out.println(postorderTraversalByStack(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode currNode = root;
        traversal(currNode, res);
        return res;
    }

    /**
     * 递归函数 左 右 根
     * @param currNode 当前节点
     * @param res 结果集
     */
    public static void traversal(TreeNode currNode, List<Integer> res) {
        if (currNode == null) {
            return;
        }
        traversal(currNode.left, res);
        traversal(currNode.right, res);
        res.add(currNode.val);
    }

    /**
     * 迭代法
     * @param root 根节点
     * @return 结果集
     */
    public static List<Integer> postorderTraversalByStack(TreeNode root) {
       if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            // 遍历左子树, 将所有节点入栈 模拟递归
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // root 为空, 左子树已经到头，弹出栈顶节点
                // 遍历右子树
                root = stack.pop();
                root = root.right;
            }
        }

        return list;
    }

}
