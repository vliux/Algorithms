package com.vliux;

/**
 * Created by vliux on 1/7/17.
 */
public class TurningIndex {
    public static void main(){
        final int[] a = new int[]{12, 19, 10};
        int index = -1;
        if(a.length >= 3) {
            index = findTurningIndex(a, 0, a.length - 1);
        }
        if(index >= 0)
            System.out.println(a[index]);
        else System.out.println("Not a turning array");
    }

    public static int findTurningIndex(final int[] a, final int start, final int end){
        if(start > end) return -1;
        final int m = (start + end)/2;
        final int pm = m -1;
        final int nm = m + 1;
        if(pm >= 0 && nm <= a.length - 1){
            final int vm = a[m];
            final int vpm = a[pm];
            final int vnm = a[nm];
            if(vpm < vm && vnm < vm) return m;
            else if(vpm < vm) return findTurningIndex(a, m, end);
            else return findTurningIndex(a, start, m);
        }else {
            return -1;
        }
    }
}
