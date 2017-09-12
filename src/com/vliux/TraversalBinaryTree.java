package com.vliux;

import com.vliux.util.TreeNode;

import java.util.Stack;

/**
 * Created by vliux on 1/3/17.
 */
public class TraversalBinaryTree {
    public static void main(){
        /*TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n2 = new TreeNode(2, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        n1.left = n2;
        n2.left = n3;
        n3.right = n4;
        n1.right = n5;
        n5.left = n6;
        n5.right = n7;
        System.out.print("inorder: ");
        inorder(n1);
        System.out.println();
        System.out.print("preorder: ");
        preorder(n1);*/

        TreeNode n10 = new TreeNode(10);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        n10.left = n6;
        n6.left = n4;
        n6.right = n8;

        TreeNode n14 = new TreeNode(14);
        TreeNode n12 = new TreeNode(12);
        TreeNode n16 = new TreeNode(16);
        n10.right = n14;
        n14.left = n12;
        n14.right = n16;
        TreeNode list = transferToDoubleLinkedList(n10);
        while(null != list){
            System.out.print(list.value + " <-> ");
            list = list.right;
        }

    }

    private static void inorderRecursively(final TreeNode root){
        if(null == root) return;
        if(root.left != null) inorderRecursively(root.left);
        System.out.print(root.value + ", ");
        if(root.right != null) inorderRecursively(root.right);
    }

    private static TreeNode transferToDoubleLinkedList(final TreeNode root){
        TreeNode sentry = new TreeNode(Integer.MIN_VALUE);
        _transferToDoubleLinkedList(root, sentry);
        return sentry;
    }

    private static TreeNode _transferToDoubleLinkedList(final TreeNode root, TreeNode listTail){
        if(null == root) return listTail;
        if(root.left != null) listTail = _transferToDoubleLinkedList(root.left, listTail);
        //System.out.print(root.value + ", ");
        listTail.right = root;
        root.left = listTail;
        listTail = root;
        if(root.right != null) listTail = _transferToDoubleLinkedList(root.right, listTail);
        return listTail;
    }


    public static void inorder(final TreeNode root){
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (true){
            if(null != current) {
                stack.push(current);
                while (null != current.left) {
                    stack.push(current.left);
                    current = current.left;
                }
            }

            if(!stack.isEmpty()) {
                TreeNode n = stack.pop();
                System.out.print(n.value + ", ");
                if(null != n.right) current = n.right;
                else current = null;
            }else return;
        }
    }

    public static void preorder(final TreeNode root){
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (true){
            if(null != current) {
                stack.push(current);
                System.out.print(current.value + ", ");
                while (null != current.left) {
                    stack.push(current.left);
                    System.out.print(current.left.value + ", ");
                    current = current.left;
                }
            }

            if(!stack.isEmpty()) {
                TreeNode n = stack.pop();
                if(null != n.right) current = n.right;
                else current = null;
            }else return;
        }
    }
}
