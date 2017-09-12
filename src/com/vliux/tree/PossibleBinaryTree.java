package com.vliux.tree;

/**
 * Created by vliux on 2017/9/6.
 */
public class PossibleBinaryTree {
    /**
     * https://www.youtube.com/watch?v=RUB5ZPfKcnY
     * Given a preorder traversal of binary tree, calculate how many possible binary trees can be formed from it.
     */
    public static class Preorder {
        public int calculatePossibleNumber(final int[] preorder){
            if(preorder.length <= 1) return 1;
            int[] results = new int[preorder.length + 1];
            results[0] = 1;
            results[1] = 1;
            for(int i = 2; i <= preorder.length; i++){
                for(int j = i - 1; j >= 0; j--){
                    results[i] += results[j] * results[i - 1 - j];
                }
            }
            return results[preorder.length];
        }
    }

    public static void main(String[] args){
        Preorder preorder = new Preorder();
        System.out.println(preorder.calculatePossibleNumber(new int[0]));
        System.out.println(preorder.calculatePossibleNumber(new int[]{10}));
        System.out.println(preorder.calculatePossibleNumber(new int[]{10,14,15}));
        System.out.println(preorder.calculatePossibleNumber(new int[]{10,14,15,16}));
        System.out.println(preorder.calculatePossibleNumber(new int[]{10,14,15,16,17}));
    }

}
