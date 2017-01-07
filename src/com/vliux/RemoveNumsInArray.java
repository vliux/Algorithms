package com.vliux;

/**
 * Created by vliux on 1/4/17.
 */
public class RemoveNumsInArray {
    public static void main(){
        final int[] a = new int[]{2};
        System.out.print("New length = ");
        System.out.println(removeNumsInArray(a, 2));
        System.out.println("Elements: ");
        for(int av : a) System.out.println(av);
    }

    private static int removeNumsInArray(final int[] a, final int v){
        if(null == a || a.length <= 0) return 0;
        int i = 0;
        int l = a.length -1;
        while (i < l){
            if(a[i] == v){
                swap(a, i, l);
                l--;
            }else i++;
        }

        if(a[i] == v) l--;
        return l+1;
    }

    private static void swap(final int[] a, final int indexA, final int indexB){
        final int va = a[indexA];
        a[indexA] = a[indexB];
        a[indexB] = va;
    }
}
