package com.vliux;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vliux on 12/31/16.
 * Given an array of ints = [6, 4, 0, 5, 0, 0, 0, 1, 0] move all non zero numbers to the left and zeros to the right.
 * Can you improve your answer to O(n)?
 */
public class MoveZerosRight {
    public static void main(){
        for(final int v : move(new int[]{6, 4, 0, 5, 0, 0, 0, 1, 0})){
            System.out.println(v);
        }
    }

    private static int[] move(final int[] a){
        final List<Integer> zeroIndicies = new ArrayList<>();
        final List<Integer> nonZeroIndicies = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            if(a[i] == 0) zeroIndicies.add(i);
            else nonZeroIndicies.add(i);
        }

        if(zeroIndicies.size() <= 0 || nonZeroIndicies.size() <= 0) return a;

        int indexZero = 0;
        int indexNonZero = nonZeroIndicies.size() - 1;
        while(indexZero < zeroIndicies.size() && indexNonZero >= 0){
            final int iz = zeroIndicies.get(indexZero);
            final int inz = nonZeroIndicies.get(indexNonZero);
            if(iz < inz){
                swap(a, iz, inz);
                indexZero ++;
                indexNonZero --;
            }else break;
        }
        return a;
    }

    private static void swap(final int[] a, final int indexA, final int indexB){
        final int vA = a[indexA];
        a[indexA] = a[indexB];
        a[indexB] = vA;
    }
}
