package com.vliux;

/**
 * Created by vliux on 12/20/16.
 */
public class SelectionNthNum {
    /**
     * Given an array, return the N-th smallest number.
     * @param array
     * @param n
     * @return
     */
    public static int nth(final int[] array, final int n){
        return nth(array, 0, array.length - 1, n);
    }

    private static int nth(final int[] array, final int left, final int right, final int n){
        if(left > right) return -1;

        final int p = pivot(array, left, right);
        if(p == n){
            return array[p];
        }else if(p > n){
            return nth(array, left, p - 1, n);
        }else {
            return nth(array, p + 1, right, n);
        }
    }

    private static int pivot(final int[] array, final int left, final int right){
        if(left == right) return left;
        final int mid = (left + right)/2;
        final int midValue = array[mid];
        swap(array, mid, right);

        int storeIndex = left;
        for(int i = left; i < right; i++){
            if(array[i] < midValue) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        //final StringBuilder sb = new StringBuilder("pivot(left=");
        //sb.append(left).append(", right=").append(right).append("\n  ");
        //for(int i = left; i <= right; i++)
        //    sb.append(array[i]).append(", ");
        //sb.append("  pivot=").append(storeIndex);
        //System.out.println(sb.toString());
        return storeIndex;
    }

    private static void swap(final int[] array, final int indexA, final int indexB){
        final int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }
}
