package com.vliux.util;

/**
 * Created by vliux on 1/3/17.
 */
public class BinaryTreeNode {
    public BinaryTreeNode left, right;
    public int value;

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
