package com.vliux;

import com.vliux.util.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by vliux on 1/3/17.
 */
public class TraversalBinaryTree {
    public static void main(){
        /*BinaryTreeNode n1 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode n2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode n3 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode n4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode n5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode n6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode n7 = new BinaryTreeNode(7, null, null);
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

        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        n10.left = n6;
        n6.left = n4;
        n6.right = n8;

        BinaryTreeNode n14 = new BinaryTreeNode(14);
        BinaryTreeNode n12 = new BinaryTreeNode(12);
        BinaryTreeNode n16 = new BinaryTreeNode(16);
        n10.right = n14;
        n14.left = n12;
        n14.right = n16;
        BinaryTreeNode list = transferToDoubleLinkedList(n10);
        while(null != list){
            System.out.print(list.value + " <-> ");
            list = list.right;
        }

    }

    private static void inorderRecursively(final BinaryTreeNode root){
        if(null == root) return;
        if(root.left != null) inorderRecursively(root.left);
        System.out.print(root.value + ", ");
        if(root.right != null) inorderRecursively(root.right);
    }

    private static BinaryTreeNode transferToDoubleLinkedList(final BinaryTreeNode root){
        BinaryTreeNode sentry = new BinaryTreeNode(Integer.MIN_VALUE);
        _transferToDoubleLinkedList(root, sentry);
        return sentry;
    }

    private static BinaryTreeNode _transferToDoubleLinkedList(final BinaryTreeNode root, BinaryTreeNode listTail){
        if(null == root) return listTail;
        if(root.left != null) listTail = _transferToDoubleLinkedList(root.left, listTail);
        //System.out.print(root.value + ", ");
        listTail.right = root;
        root.left = listTail;
        listTail = root;
        if(root.right != null) listTail = _transferToDoubleLinkedList(root.right, listTail);
        return listTail;
    }


    public static void inorder(final BinaryTreeNode root){
        final Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;

        while (true){
            if(null != current) {
                stack.push(current);
                while (null != current.left) {
                    stack.push(current.left);
                    current = current.left;
                }
            }

            if(!stack.isEmpty()) {
                BinaryTreeNode n = stack.pop();
                System.out.print(n.value + ", ");
                if(null != n.right) current = n.right;
                else current = null;
            }else return;
        }
    }

    public static void preorder(final BinaryTreeNode root){
        final Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;

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
                BinaryTreeNode n = stack.pop();
                if(null != n.right) current = n.right;
                else current = null;
            }else return;
        }
    }
}
