package com.leetcode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */
public class BinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode sentry = new TreeNode(Integer.MIN_VALUE);
        flattern(root, sentry);

        TreeNode cur = sentry;
        while (null != cur){
            System.out.print(cur.val + ", ");
            cur = cur.right;
            assert null == cur.left;
        }
    }

    private TreeNode flattern(TreeNode root, TreeNode listTail){
        if(null == root) return listTail;
        TreeNode left = root.left;
        TreeNode right = root.right;
        listTail.right = root; listTail.left = null;
        TreeNode newTail = flattern(left, root);
        return flattern(right, newTail);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        BinaryTreeToLinkedList flattern = new BinaryTreeToLinkedList();
        flattern.flatten(root);
    }
}
