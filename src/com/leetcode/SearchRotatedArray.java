package com.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchRotatedArray {
    public int search(int[] a, int target){
        int p = pivot(a);
        System.out.println("pivot=" + p);
        if(p >= 0) return search(a, target, 0, a.length - 1, p);
        else return -1;
    }

    private int search(int[] a, int target, int fStart, int fEnd, int pivot){
        if(fStart > fEnd) return -1;
        int fMid = (fStart + fEnd)/2;
        // coordinator transfer
        int m = transferIndex(pivot, fMid, a.length);
        //System.out.println("transfered_mid=" + fMid + " mid=" + m);
        int start = transferIndex(pivot, fStart, a.length);
        int end = transferIndex(pivot, fEnd, a.length);

        if(a[m] == target) return m;
        else if(a[m] > target) return search(a, target, fStart, fMid - 1, pivot);
        else return search(a, target, fMid + 1, fEnd, pivot);
    }

    private int transferIndex(int pivot, int fIndex, int len){
        int index = fIndex + pivot;
        if(index <= len - 1) return index;
        else return index - len;
    }

    private int pivot(int[] a){
        return pivot(a, 0, a.length - 1);
    }

    private int pivot(int[] a, int start, int end){
        if(start > end) return -1;
        int m = (start + end)/2;
        if(m > 0 && a[m-1] > a[m]) return m;
        else if(m < a.length - 1 && a[m+1] < a[m]) return m + 1;
        else{
            if(a[start] > a[m]) return pivot(a, start, m - 1);
            else if(a[end] < a[m]) return pivot(a, m + 1, end);
            else return 0;
        }
    }

    private static void doMain1(){
        //                  0 1 2 3 4 5  6  7  8  9 10 11 12 13  14
        int[] a = new int[]{4,5,6,7,8,9,10,11,12,13,14, 0, 1, 2, 3};
        SearchRotatedArray sra = new SearchRotatedArray();
        System.out.println(sra.search(a, 13));
        System.out.println(sra.search(a, 14));
        System.out.println(sra.search(a, 15));
    }

    private static void doMain2(){
        int[] a = new int[]{4};
        SearchRotatedArray sra = new SearchRotatedArray();
        System.out.println(sra.search(a, 13));
        System.out.println(sra.search(a, 4));
    }

    public static void main(String[] args){
        doMain2();
        /*
        System.out.println(sra.transferIndex(p, 0, a.length));
        System.out.println(sra.transferIndex(p, 4, a.length));
        System.out.println(sra.transferIndex(p, 10, a.length));
        System.out.println(sra.transferIndex(p, 14, a.length));
        */
        //System.out.println(sra.pivot(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14}));
        //System.out.println(sra.pivot(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,0}));
    }
}
