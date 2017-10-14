package com.leetcode;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    /**
     * Solution 2: http://www.geeksforgeeks.org/longest-increasing-subsequence/
     * Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
     Then, L(i) can be recursively written as:
     L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
     L(i) = 1, if no such j exists.
     */
    static int max_ref; // stores the LIS

    /* To make use of recursive calls, this function must return
    two things:
    1) Length of LIS ending with element arr[n-1]. We use
       max_ending_here for this purpose
    2) Overall maximum as the LIS may end with an element
       before arr[n-1] max_ref is used this purpose.
    The value of LIS of full array of size n is stored in
    *max_ref which is our final result */
    private static int _lis(int arr[], int n)
    {
        // base case
        if (n == 1)
            return 1;

        // 'max_ending_here' is length of LIS ending with arr[n-1]
        int res, max_ending_here = 1;

        /* Recursively get all LIS ending with arr[0], arr[1] ...
           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
           max ending with arr[n-1] needs to be updated, then
           update it */
        for (int i = 1; i < n; i++)
        {
            res = _lis(arr, i);
            if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
                max_ending_here = res + 1;
        }

        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;

        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }

    // The wrapper function for _lis()
    public static int lis(int arr[])
    {
        // The max variable holds the result
        max_ref = 1;

        // The function _lis() stores its result in max
        _lis( arr, arr.length);

        // returns max
        return max_ref;
    }

    public static void main(String[] args){
        //LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 29, 31};
        System.out.println(LongestIncreasingSubsequence.lis(arr));
    }
}
