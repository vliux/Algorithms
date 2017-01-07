package com.vliux;

/**
 * Created by vliux on 1/7/17.
 */
public class GivenSum {
    public static void main(){
        givenSum(new int[]{1,2,4,11,17}, 15);
        givenSum(new int[]{1}, 15);
        givenSum(new int[]{15}, 15);
    }

    /**
     * Given an increasingly sorted array and a number s, please find two numbers whose sum is s. If there are multiple pairs with sum s, just output any one of them.
     * @param a
     * @param sum
     */
    public static void givenSum(final int[] a, final int sum){
        if(null == a || a.length <= 0) {
            System.out.println("Not found as a is empty");
            return;
        }else if(a.length == 1){
            if(a[0] == sum) {
                System.out.println(String.format("%d = %d", a[0], sum));
            }else {
                System.out.println("Not found as A has only one element != " + sum);
            }
            return;
        }

        int ll = 0;
        int lh = a.length -1;
        while(ll < lh){
            int s = a[ll] + a[lh];
            if(s == sum){
                System.out.println(String.format("%d + %d = %d", a[ll], a[lh], sum));
                return;
            }else if(s < sum){
                ll++;
            }else {
                lh--;
            }
        }
    }
}
