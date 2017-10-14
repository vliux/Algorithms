package com.vliux;

/**
 * Created by vliux on 12/20/16.
 */
public class LongestPalindromicSubstr {

    public static void main(String[] args){
        lps2("kbububkaccabba");
        lps2("ab");
        lps2("yabbaycdbc");
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
                    //System.out.println(String.format("found palindromic=%s", s.substring(i-1, j)));
                    t[i][j] = len;
                    if(len > longest){
                        longest = len;
                        System.out.println(String.format("[1] longest so far = %s, sub-str=%s", longest, s.substring(i-1, j)));
                    }
                }
            }
        }
    }

    private static void lps2(final String s){
        if(null == s || s.length() <= 0) {
            System.out.println("empty string");
            return;
        }
        final int[][] f = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++)
            f[i][i] = 1;

        int longest = 0;
        int mi = 0;
        int mj = 0;
        for(int i = s.length() - 2; i >= 0; i--){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    int pi = i+1; int pj = j-1;
                    if(pi <= pj) {
                        if(f[pi][pj] > 0) f[i][j] = 2 + f[pi][pj];
                        else f[i][j] = 0;
                    }else
                        f[i][j] = 2;
                    if(f[i][j] > longest){
                        System.out.println(String.format("Current longest=%d, i=%d, j=%d", f[i][j], i, j));
                        mi = i; mj = j;
                    }
                }
            }
        }
        System.out.println(String.format("longest_palindrom=%d, i=%d, j=%d, value=%s", f[mi][mj], mi, mj, s.substring(mi, mj+1)));
    }
}
