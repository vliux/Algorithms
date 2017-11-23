package com.leetcode;

public class SplitKSubsetsEqualSum {
    public static void main(String[] args){
        int[] a = new int[]{3,1,4,2,4};
        System.out.println(canDivide(a, new boolean[a.length], 3, 0, 5));
    }

    public static boolean canDivide(int[] a, boolean[] visited, int k, int sumCurr, int tgtSum){
        if(k == 0) return true;
        for(int i = 0; i < visited.length; i++){
            if(! visited[i] && sumCurr + a[i] <= tgtSum){
                visited[i] = true;
                sumCurr += a[i];
                boolean b = (sumCurr == tgtSum);
                if(canDivide(a, visited,
                        b ? k-1 : k,
                        b ? 0 : sumCurr,
                        tgtSum)) return true;
                visited[i] = false;
                sumCurr -= a[i];
            }
        }
        return false;
    }
}
