package com.leetcode;

import com.vliux.util.Arrays;

/**
 * http://articles.leetcode.com/rotating-array-in-place/
 * Rotate a one-dimensional array of n elements to the right by k steps.
 For instance, with n=7 and k=3, the array {a, b, c, d, e, f, g} is rotated to {e, f, g, a, b, c, d}.
 */
public class RotateArrayInPlace {
    public void rotate(int[] a, int k){
        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
    }

    private void reverse(int[] a, int start, int end){
        if(start >= end) return;
        while(start < end){
            int va = a[start];
            a[start] = a[end];
            a[end] = va;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5,6,7};
        RotateArrayInPlace raip = new RotateArrayInPlace();
        raip.rotate(a, 6);
        Arrays.printArray(a);
    }
}
