package com.vliux;

/**
 * Created by vliux on 12/20/16.
 * Find the lowest common ancestor in a binary tree (not a binary search tree!) of 2 nodes.
 */
public class LowestCommonAncestorBinaryTree {
    public static class Node {
        public int value;
        public Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void lca(){
        Node n = new Node(3);
        Node root = n;
        Node l = new Node(6);
        Node r = new Node(8);
        n.left = l;n.right = r;

        n = l;
        l = new Node(2);
        r = new Node(11);
        n.left = l; n.right = r;

        n = r;
        l = new Node(9);
        r = new Node(5);
        n.left = l; n.right = r;

        Node result = lca(root, 2, 8);
    }

    private static Node lca(final Node root, final int va, final int vb){
        if(null == root) return null;
        else if(va == root.value) return root;
        else if(vb == root.value) return root;
        else {
            final Node left = lca(root.left, va, vb);
            final Node right = lca(root.right, va, vb);
            if(null != left && null != right){
                System.out.println("LCA found: " + root.value);
                return root;
            }else if(null != left) return left;
            else if(null != right) return right;
            else return null;
        }
    }

}
