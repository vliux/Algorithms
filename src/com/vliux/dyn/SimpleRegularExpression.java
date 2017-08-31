package com.vliux.dyn;

/**
 * Created by vliux on 2017/8/30.
 * From: Regular Expression Dynamic Programming
 * https://www.youtube.com/watch?v=l3hda49XcDE
 *
 * Given a text and a pattern, check whether the text matches the pattern.
 * The pattern supports:
 * "." as any single char.
 * "*" matches 0 or more occurances before it.
 */
public class SimpleRegularExpression {

    /**
     * If t[i] == p[j] || p[j] == '.', then T[i][j] = T[i-1][j-1];
     * If p[j] == "*", then
     *     if T[i][j-2] == true, then T[i][j] = true,
     *     else if t[i] == p[j-1] || p[j-1] == '.', T[i][j] = T[i-1][j];
     * Else return false;
     */
    private static boolean match(final char[] text, final char[] pattern){
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];
        T[0][0] = true;
        for(int i = 1; i < T[0].length; i++){
            if(pattern[i-1] == '*'){
                T[0][i] = T[0][i-2];
            }
        }

        for(int i = 1; i < T.length; i++){
            for(int j = 1; j < T[0].length; j++){
                if(text[i-1] == pattern[j-1] || pattern[j-1] == '.'){
                    T[i][j] = T[i-1][j-1];
                }else if(pattern[j-1] == '*'){
                    T[i][j] = T[i][j-2];
                    if(text[i-1] == pattern[j-2] || pattern[j-2] == '.'){
                        T[i][j] = (T[i][j] | T[i-1][j]);
                    }
                }else T[i][j] = false;
            }
        }

        final boolean result =  T[text.length][pattern.length];
        System.out.println(String.format("[%s] text=%s, pattern=%s", result, String.valueOf(text), String.valueOf(pattern)));
        printT(text, pattern, T);
        return result;
    }

    private static void printT(char[] text, char[] pattern, boolean[][] T){
        for(int j = 0; j < T[0].length; j++) {
            if(j == 0) System.out.print("  ");
            else System.out.print(String.valueOf(pattern[j - 1]) + " ");
        }
        System.out.println();

        for(int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[0].length; j++) {
                System.out.print(T[i][j]? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        match("vliux".toCharArray(), "vliux".toCharArray());
        match("vliux".toCharArray(), "vliux*".toCharArray());
        match("vliux".toCharArray(), ".liu.*".toCharArray());
    }
}
