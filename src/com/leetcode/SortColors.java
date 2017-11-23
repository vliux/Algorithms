package com.leetcode;

/**
 * https://leetcode.com/problems/sort-colors/description/
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {

    public void sort(int[] a){
        int whiteStart = partition(a, 0, 0, a.length - 1);
        partition(a, 1, whiteStart, a.length - 1);
    }

    /**
     * @param a
     * @param target the value to compare
     * @param si start index of a, inclusive
     * @param ei end index of a, inclusive
     * @return the index after the last ocurrance of target in a.
     */
    private int partition(int[] a, int target, int si, int ei){
        if(si >= ei) return si;
        int store = si;
        for(int i = si; i <= ei; i++){
            if(a[i] <= target){
                swap(a, store, i);
                store++;
            }
        }
        return store;
    }

    private static void swap(int[] a, int ai, int bi){
        if(ai != bi){
            int va = a[ai];
            a[ai] = a[bi];
            a[bi] = va;
        }
    }

    public static void main(String[] args){
        SortColors sc = new SortColors();
        int[] a = new int[]{2, 0, 1, 0, 2, 1, 1, 0, 1, 2, 1, 0, 0, 1, 2};
        sc.sort(a);
        for(int va : a){
            System.out.print(va);
            System.out.print(", ");
        }
    }
}
