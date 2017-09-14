package com.vliux.matrix;

/**
 * http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 */
public class RotateInPlace {
    public static void rotateAntiClock90(int[][] m){
        int len = m.length;
        for(int i = 0; i < len/2; i++) { // len/2 sub-circles, one inside another
            for (int j = 0; j < len - 1 - 2 * i; j++) { // swap items in each sub-circle
                swap(m, i, i + j, len - 1 - i - j, i);
                swap(m, i, i + j, i + j, len - 1 - i);
                swap(m, len - 1 - i, len - 1 - i - j, i + j, len - 1 - i);
                System.out.println("\nround " + i + ":");
                printMatrix(m);
            }
        }
    }

    private static void swap(int[][] m, int srcRow, int srcCol, int tgtRow, int tgtCol){
        int t = m[srcRow][srcCol];
        m[srcRow][srcCol] = m[tgtRow][tgtCol];
        m[tgtRow][tgtCol] = t;
    }

    private static void printMatrix(int[][] m){
        for(int i = 0; i < m.length; i++) {
            System.out.println();
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j]);
                System.out.print(' ');
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        int n = 5;
        int[][] m = new int[n][n];
        int v = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                m[i][j] = v++;
            }
        }
        printMatrix(m);
        rotateAntiClock90(m);
    }
}
