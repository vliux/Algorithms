package com.vliux;

/**
 * Created by vliux on 12/20/16.
 */
public class LongestCommonSubstring {
    public static void exec() {
        final String s = "bcdaeawgrragwa";
        final String t = "wgrragwahawgrrafvxfg";
        System.out.println("LCS1 = " + longestCommonSubstring(s, t));
        System.out.println("LCS2 = " + lcs(s, t));

        System.out.println("LCS1 = " + longestCommonSubstring("wgtwdfg", "adfgtwd"));
        System.out.println("LCS2 = " + lcs("wgtwdfg", "adfgtwd"));
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
            /*if(jx == 1){
                jx += 1;
                for(int jj = 1; jj <= lt; jj++) {
                    if(jj ==1 ) System.out.print("   ");
                    System.out.print(t.charAt(jj - 1) + ", ");
                }
                System.out.println();
            }
            System.out.print("\n" + s.charAt(i-1) + ": ");*/
            // core logic
            for(int j = 1; j <= lt; j++){
                int v;
                if(s.charAt(i-1) == t.charAt(j-1)){
                    v = r[i-1][j-1] + 1;
                }else v = 0;
                //System.out.print(v + ", ");
                r[i][j] = v;
                if(v > longest){
                    longest = v;
                }
            }
        }
        return longest;
    }

    // don't need extra column and row in matrix.
    private static int lcs(final String s, final String t){
        final int[][] f = new int[s.length()][t.length()];
        f[0][0] = (s.charAt(0)==t.charAt(0)? 1 : 0);
        int longest = 0;
        for(int i = 1; i < t.length()-1; i++){
            f[0][i] = (t.charAt(i)==s.charAt(0) ? f[0][i-1]+1 : 0);
            if(f[0][i] > longest) longest = f[0][i];
        }
        for(int i = 1; i < s.length()-1; i++){
            f[i][0] = (s.charAt(i)==t.charAt(0) ? f[i-1][0]+1 : 0);
            if(f[i][0] > longest) longest = f[i][0];
        }

        for(int i = 1; i < s.length(); i++){
            for(int j = 1; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    f[i][j] = f[i-1][j-1] + 1;
                    if(f[i][j] > longest) longest = f[i][j];
                }else f[i][j] = 0;
            }
        }
        return longest;
    }
}
