package com.leetcode;

/**
 * Created by vliux on 2017/9/6.
 */
public class Atoi {
    public static int myAtoi(String str) {
        if(null == str || str.length() <= 0) throw new NumberFormatException();
        int v = 0;
        boolean neg = false;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i == 0){
                if(c == '+'){
                    neg = false;
                    continue;
                }else if(c == '-'){
                    neg = true;
                    continue;
                }
            }
            if(c >= '0' && c <= '9'){
                int t = c - 48;
                v = v*10 + t;
            }else throw new NumberFormatException();
        }
        return neg ? -v : v;
    }

    public static void rr(String s){
        try {
            System.out.print("str=" + s);
            System.out.println(String.format(", result=%d", myAtoi(s)));
        }catch (Exception e){
            System.out.println("exception: " + e);
        }
    }

    public static void main(String[] args){
        rr("123");
        rr("-123");
        rr("12.3");
        rr("1a23");
        rr("");
        rr("0");
    }
}
