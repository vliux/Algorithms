package com.vliux;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigzagConversion {
    public String zigzag(String text, int rows){
        if(null == text || text.length() <= 0) return "";
        if(rows <= 1) return text;

        StringBuilder sb = new StringBuilder();
        final int sl = 2 * rows - 2;
        for(int i = 0; i < rows; i++){
            //if(i > 0) sb.append("\n");
            // rows may be > text.length()
            if(i < text.length()) sb.append(text.charAt(i));
            int delta = sl;
            if(i > 0 && i < rows -1) delta = delta / 2;
            for(int cur = i + delta; cur < text.length(); cur += delta){
                sb.append(text.charAt(cur));
            }
        }
        return sb.toString();
    }

    public static void main(final String[] args){
        System.out.println(new ZigzagConversion().zigzag("PAYPALISHIRING", 3));
    }
}
