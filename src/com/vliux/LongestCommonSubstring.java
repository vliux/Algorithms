package com.vliux;

/**
 * Created by vliux on 12/20/16.
 */
public class LongestCommonSubstring {
    public static void exec() {
        final String s = "bcdaeawgrragwa";
        final String t = "wgrragwahawgrrafvxfg";
        System.out.println("LCS = " + longestCommonSubstring(s, t));
    }

    /**
     * Given two strings s and t, find the longest common substring.
     * @param s
     * @param t
     * @return
     */
    private static int longestCommonSubstring(final String s, final String t){
        final int ls = s.length();
        final int lt = t.length();
        final int[][] r = new int[ls+1][lt+1];
        int longest = 0;
        int jx = 1;
        for(int i = 1; i <= ls; i++){
            // just print
            if(jx == 1){
                jx += 1;
                for(int jj = 1; jj <= lt; jj++) {
                    if(jj ==1 ) System.out.print("   ");
                    System.out.print(t.charAt(jj - 1) + ", ");
                }
                System.out.println();
            }
            System.out.print("\n" + s.charAt(i-1) + ": ");
            // core logic
            for(int j = 1; j <= lt; j++){
                int v;
                if(s.charAt(i-1) == t.charAt(j-1)){
                    v = r[i-1][j-1] + 1;
                }else v = 0;
                System.out.print(v + ", ");
                r[i][j] = v;
                if(v > longest){
                    longest = v;
                }
            }
        }
        return longest;
    }
}
