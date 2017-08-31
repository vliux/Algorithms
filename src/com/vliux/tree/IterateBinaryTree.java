package com.vliux.tree;

import java.util.*;

/**
 * Created by vliux on 2017/8/31.
 * Iterator of pre/in/post-order traversal.
 * Copied from https://codereview.stackexchange.com/questions/41844/iterator-for-binary-tree-pre-in-and-post-order-iterators
 */
public class IterateBinaryTree<E> {

    private TreeNode<E> root;

    /**
     * Takes in a BFS representation of a tree, and converts it into a tree.
     * here the left and right children of nodes are the (2*i + 1) and (2*i + 2)nd
     * positions respectively.
     *
     * @param items The items to be node values.
     */
    public IterateBinaryTree(List<? extends E> items) {
        create(items);
    }

    private static class TreeNode<E> {
        TreeNode<E> left;
        E item;
        TreeNode<E> right;

        TreeNode(TreeNode<E> left, E item, TreeNode<E> right) {
            this.left = left;
            this.item = item;
            this.right = right;
        }
    }

    private void create (List<? extends E> items) {
        root = new TreeNode<E>(null, items.get(0), null);

        final Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        queue.add(root);

        final int half = items.size() / 2;

        for (int i = 0; i < half; i++) {
            if (items.get(i) != null) {
                final TreeNode<E> current = queue.poll();
                final int left = 2 * i + 1;
                final int right = 2 * i + 2;

                if (items.get(left) != null) {
                    current.left = new TreeNode<E>(null, items.get(left), null);
                    queue.add(current.left);
                }
                if (right < items.size() && items.get(right) != null) {
                    current.right = new TreeNode<E>(null, items.get(right), null);
                    queue.add(current.right);
                }
            }
        }
    }


    /**
     * Returns the preorder representation for the given tree.
     *
     * @return  the iterator for preorder traversal
     */
    public Iterator<E> preOrderIterator () {
        return new PreOrderItr();
    }

    private class PreOrderItr implements Iterator<E> {
        private final Stack<TreeNode<E>> stack;

        public PreOrderItr() {
            stack = new Stack<TreeNode<E>>();
            stack.add(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");

            final TreeNode<E> node = stack.pop();

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            return node.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid operation for pre-order iterator.");
        }
    }

    /**
     * Returns the in-order representation for the given tree.
     *
     * @return  the iterator for preorder traversal
     */
    public Iterator<E> inorderIterator() {
        return new InOrderItr();
    }

    private class TreeNodeDataInOrder {
        TreeNode<E> treeNode;
        boolean visitedLeftBranch;

        TreeNodeDataInOrder(TreeNode<E> treeNode, Boolean foo) {
            this.treeNode = treeNode;
            this.visitedLeftBranch = foo;
        }
    }

    private class InOrderItr implements Iterator<E> {
        private final Stack<TreeNodeDataInOrder> stack;

        public InOrderItr() {
            stack = new Stack<TreeNodeDataInOrder>();
            stack.add(new TreeNodeDataInOrder(root, false));
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");

            while (hasNext()) {
                final TreeNodeDataInOrder treeNodeData = stack.peek();
                final TreeNode<E> treeNode = treeNodeData.treeNode;

                if (!treeNodeData.visitedLeftBranch) {
                    if (treeNode.left != null) {
                        stack.add(new TreeNodeDataInOrder(treeNode.left, false));
                    }
                    treeNodeData.visitedLeftBranch = true;
                } else {
                    stack.pop();
                    if (treeNode.right != null) {
                        stack.add(new TreeNodeDataInOrder(treeNode.right, false));
                    }
                    return treeNode.item;
                }
            }
            throw new AssertionError("A node has not been returned when it should have been.");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid operation for in-order iterator.");
        }

    }

    /**
     * Returns the post-order representation for the given tree.
     *
     * @return  the iterator for preorder traversal
     */
    public Iterator<E> postOrderIterator() {
        return new PostOrderItr();
    }

    private class TreeNodeDataPostOrder {
        TreeNode<E> treeNode;
        boolean visitedLeftAndRightBranches;

        TreeNodeDataPostOrder(TreeNode<E> treeNode, Boolean visitedLeftAndRightBranches) {
            this.treeNode = treeNode;
            this.visitedLeftAndRightBranches = visitedLeftAndRightBranches;
        }
    }

    private class PostOrderItr implements Iterator<E> {

        private final Stack<TreeNodeDataPostOrder> stack;

        private PostOrderItr() {
            stack = new Stack<TreeNodeDataPostOrder>();
            stack.add(new TreeNodeDataPostOrder(root, false));
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");

            while (hasNext()) {
                final TreeNodeDataPostOrder treeNodeData = stack.peek();
                final TreeNode<E> treeNode = treeNodeData.treeNode;

                if (!treeNodeData.visitedLeftAndRightBranches) {
                    if (treeNode.right != null) {
                        stack.add(new TreeNodeDataPostOrder(treeNode.right, false));
                    }
                    if (treeNode.left != null) {
                        stack.add(new TreeNodeDataPostOrder(treeNode.left, false));
                    }
                    treeNodeData.visitedLeftAndRightBranches = true;
                } else {
                    stack.pop();
                    return treeNode.item;
                }
            }

            throw new AssertionError("A node has not been returned when it should have been.");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid operation for post-order iterator.");
        }
    }


    public static void main(String[] args) {

        Iterator<Integer> itr = null;

        Integer[] arr = {1, 2, 3, 4, null, 6, 7};
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7}; // full
        Integer[] arr2 = {1, 2, null, 3, null, null, null}; // left skew
        Integer[] arr3 = {1, null, 3, null, null, null, 7}; // right skew
        Integer[] arr4 = {1}; // single element


        System.out.println("---- TESTING FOR PREORDER -----------");


        IterateBinaryTree<Integer> iteratePreOrder = new IterateBinaryTree<Integer>(Arrays.asList(arr));
        System.out.print("Expected: 1 2 4 3 6 7, Actual: ");
        itr = iteratePreOrder.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePreOrder1 = new IterateBinaryTree<Integer>(Arrays.asList(arr1));
        System.out.print("Expected: 1 2 4 5 3 6 7, Actual: ");
        itr = iteratePreOrder1.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePreOrder2 = new IterateBinaryTree<Integer>(Arrays.asList(arr2));
        System.out.print("Expected: 1 2 3, Actual: ");
        itr = iteratePreOrder2.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePreOrder3 = new IterateBinaryTree<Integer>(Arrays.asList(arr3));
        System.out.print("Expected: 1 3 7, Actual: ");
        itr = iteratePreOrder3.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePreOrder4 = new IterateBinaryTree<Integer>(Arrays.asList(arr4));
        System.out.print("Expected: 1, Actual: ");
        itr = iteratePreOrder4.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        System.out.println("---- TESTING FOR INORDER -----------");

        IterateBinaryTree<Integer> iterateInOrder = new IterateBinaryTree<Integer>(Arrays.asList(arr));
        System.out.print("Expected: 4 2 1 6 3 7, Actual: ");
        itr = iterateInOrder.inorderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iterateInOrder1 = new IterateBinaryTree<Integer>(Arrays.asList(arr1));
        System.out.print("Expected: 4 2 5 1 6 3 7, Actual: ");
        itr = iterateInOrder1.inorderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iterateInOrder2 = new IterateBinaryTree<Integer>(Arrays.asList(arr2));
        System.out.print("Expected: 3 2 1, Actual: ");
        itr = iterateInOrder2.inorderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iterateInOrder3 = new IterateBinaryTree<Integer>(Arrays.asList(arr3));
        System.out.print("Expected: 1 3 7, Actual: ");
        itr = iterateInOrder3.inorderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iterateInOrder4 = new IterateBinaryTree<Integer>(Arrays.asList(arr4));
        System.out.print("Expected: 1, Actual: ");
        itr = iterateInOrder4.inorderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        System.out.println("---- TESTING FOR POSTORDER -----------");

        IterateBinaryTree<Integer> iteratePostOrder = new IterateBinaryTree<Integer>(Arrays.asList(arr));
        System.out.print("Expected: 4 2 6 7 3 1, Actual: ");
        itr = iteratePostOrder.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePostOrder1 = new IterateBinaryTree<Integer>(Arrays.asList(arr1));
        System.out.print("Expected: 4 5 2 6 7 3 1, Actual: ");
        itr = iteratePostOrder1.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePostOrder2 = new IterateBinaryTree<Integer>(Arrays.asList(arr2));
        System.out.print("Expected: 3 2 1, Actual: ");
        itr = iteratePostOrder2.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePostOrder3 = new IterateBinaryTree<Integer>(Arrays.asList(arr3));
        System.out.print("Expected: 7 3 1, Actual: ");
        itr = iteratePostOrder3.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterateBinaryTree<Integer> iteratePostOrder4 = new IterateBinaryTree<Integer>(Arrays.asList(arr4));
        System.out.print("Expected: 1, Actual: ");
        itr = iteratePostOrder4.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}