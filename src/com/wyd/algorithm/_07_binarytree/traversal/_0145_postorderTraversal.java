package com.wyd.algorithm._07_binarytree.traversal;

import com.wyd.algorithm._07_binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wyd
 * @Description: 后序遍历
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
        traversal(root, res);
        return res;
    }

    /**
     * 递归函数 左 右 根
     *
     * @param root 当前节点
     * @param res  结果集
     */
    public static void traversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
    }

    /**
     * 迭代法
     *
     * @param root 根节点
     * @return 结果集
     */
    public static List<Integer> postorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 中 右 左
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                stack.add(root);
                root = root.right;
            } else {
                TreeNode pop = stack.pop();
                root = pop.left;
            }
        }
        // 翻转 变成 右中左
        Collections.reverse(res);
        return res;
    }

    /**
     * 迭代法
     *
     * @param root 根节点
     * @return 结果集
     */
    public static List<Integer> postorderTraversalByStack2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        // 中 右 左
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                // 将该节点弹出，避免重复操作，下面再将中右左节点添加到栈中（后序遍历-左右中，入栈顺序中右左）
                stack.pop();
                // 添加中节点
                stack.push(node);
                // 中节点访问过，但是还没有处理，加入空节点做为标记。
                stack.push(null);

                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }

            } else {
                stack.pop();
                node = stack.peek();
                stack.pop();
                res.add(node.val);
            }
        }

        return res;
    }
}
