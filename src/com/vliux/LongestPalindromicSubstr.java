package com.vliux;

/**
 * Created by vliux on 12/20/16.
 */
public class LongestPalindromicSubstr {

    public static void lps(){
        lps("kbububkaccabba");
    }

    private static void lps(final String s){
        final int ls = s.length();
        final int lss = ls + 1;
        final int[][] t = new int[lss][lss];
        for(int i = 0; i < lss; i++) t[i][i] = 1;

        int longest = 0;
        for(int i = ls - 1; i >- 0; i--){
            for(int j = i + 1; j <= ls; j++){
                if(s.charAt(i-1) == s.charAt(j-1)){
                    final int len = 2 + t[i+1][j-1];
                    System.out.println(String.format("found palindromic=%s", s.substring(i-1, j)));
                    t[i][j] = len;
                    if(len > longest){
                        longest = len;
                        System.out.println(String.format("longest so far = %s, sub-str=%s", longest, s.substring(i-1, j)));
                    }
                }
            }
        }
    }
}
