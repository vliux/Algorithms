package com.vliux;

/**
 * Created by vliux on 1/5/17.
 */
public class SearchRotatedArray {
    public static void main(){
        final int id = getIndex(new int[]{1}, 5);
        System.out.println("value at index " + id);
    }

    private static int getIndex(final int[] array, final int value){
        return searchForIndex(array, value, 0, array.length - 1);
    }

    private static int searchForIndex(final int[] array, final int value, final int start, final int end){
        if(start > end) return -1;
        final int im = (start + end)/2;
        final int vm = array[im];
        final int vs = array[start];
        if(vm == value) return im;
        if(vs == value) return start;

        if(vm > vs) {
            if (value > vs) return searchForIndex(array, value, im, end);
            else /*if (value < vs)*/ return searchForIndex(array, value, start, im);
        }else if(vm < vs){
            if (value > vs) return searchForIndex(array, value, start, im);
            else /*if (value < vm)*/ return searchForIndex(array, value, im, end);
        }else {
            if(vs == value) return start;
            else if(array[end] == value) return end;
            else return -1;
        }
    }
}
