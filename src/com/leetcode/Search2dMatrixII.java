package com.leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class Search2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) return false;
        return doSearch(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean doSearch(int[][] m, int target, int rs, int re, int cs, int ce){
        for(int i = rs; i <= re; i++){
            int v = m[i][cs];
            if(v == target){
                return true;
            }else if(v > target){
                re = i - 1;
                break;
            }
        }
        if(re < rs) return false;

        for(int j = cs; j <= ce; j++){
            int v = m[rs][j];
            if(v == target) return true;
            else if(v > target){
                ce = j - 1;
                break;
            }
        }
        if(ce < cs) return false;

        for(int p = rs; p <= re; p++){
            int v = m[p][ce];
            if(v == target) return true;
            else if(v < target){
                rs++;
            }
        }
        if(re < rs) return false;

        for(int q = cs; q <= ce; q++){
            int v = m[re][q];
            if(v == target) return true;
            else if(v < target) {
                cs++;
            }
        }
        if(ce < cs) return false;

        return doSearch(m, target, rs, re, cs, ce);
    }

    public static void main(String[] args){
        Search2dMatrixII s2m = new Search2dMatrixII();
        int[][] m = new int[][]{
                //new int[]{1,4,7,11,15}
                //new int[]{2,5,8,12,19},
                //new int[]{3,6,9,16,22},
                //new int[]{10,13,14,17,24},
                //new int[]{18,21,23,26,30}
        };
        System.out.println(s2m.searchMatrix(m, 11));
    }
}
