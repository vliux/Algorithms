package com.leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pa = m - 1;
        int pb = n - 1;
        int si = m + n -1;
        while(pa >= 0 && pb >= 0){
            if(nums1[pa] > nums2[pb]){
                nums1[si--] = nums1[pa--];
            }else{
                nums1[si--] = nums2[pb--];
            }
        }

        while(pb >= 0){
            nums1[si--] = nums2[pb--];
        }
    }
}
