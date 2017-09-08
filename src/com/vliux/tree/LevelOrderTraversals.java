package com.vliux.tree;

import com.vliux.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vliux on 2017/9/8.
 */
public class LevelOrderTraversals {
    /**
     * https://www.youtube.com/watch?v=D2bIbWGgvzI&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=14
     * Traversal a tree level by level, from bottom to top. In each level traversal from left to right.
     * To be simpler than the solution from Tushar, I use only a list data structure.
     */
    public void bottomUp(final TreeNode root){
        if(null == root) return;
        final List<TreeNode> l = new ArrayList<>();
        l.add(root);
        for(int i = 0; i < l.size(); i++){
            final TreeNode n = l.get(i);
            if(null != n.right) l.add(n.right);
            if(null != n.left) l.add(n.left);
        }

        for(int j = l.size() - 1; j >= 0; j--){
            final TreeNode n = l.get(j);
            System.out.print(n.value);
            System.out.print(' ');
        }
    }

    public static void main(final String[] args){
        final LevelOrderTraversals t = new LevelOrderTraversals();
        final TreeNode root = new TreeNode(0);
        t.bottomUp(root);
        System.out.println();

        TreeNode curr = root;
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        curr.left = l; curr.right = r;

        curr = l;
        l = new TreeNode(3);
        r = new TreeNode(4);
        curr.left = l; curr.right = r;

        t.bottomUp(root);
    }
}
