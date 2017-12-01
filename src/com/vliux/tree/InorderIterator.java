package com.vliux.tree;

import com.vliux.util.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class InorderIterator implements Iterator<TreeNode>{
    private Stack<StackEntry> mStack = new Stack<>();

    public InorderIterator(TreeNode root){
        mStack.push(new StackEntry(root, false));
    }

    @Override
    public boolean hasNext() {
        return !mStack.isEmpty();
    }

    @Override
    public TreeNode next() {
        if(!hasNext()) throw new NoSuchElementException();
        while (true) {
            StackEntry se = mStack.peek();
            if(se.leftVisited){
                mStack.pop();
                if(null != se.node.right)
                    mStack.push(new StackEntry(se.node.right, false));
                return se.node;
            }else{
                if(null != se.node.left)
                    mStack.push(new StackEntry(se.node.left, false));
                se.leftVisited = true;
            }
        }
    }

    private static class StackEntry {
        TreeNode node;
        boolean leftVisited;

        public StackEntry(TreeNode node, boolean leftVisited) {
            this.node = node;
            this.leftVisited = leftVisited;
        }
    }
}
