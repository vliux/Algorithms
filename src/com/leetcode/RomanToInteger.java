package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger {

    public static int toInt(String roman){
        int len = roman.length();
        int value = 0;
        for(int i = 0; i < len;){
            if(i < len - 1){
                String s = roman.substring(i, i + 2);
                if(M.containsKey(s)){
                    value += M.get(s);
                    i += 2;
                    continue;
                }
            }

            value += M.get(roman.substring(i, i + 1));
            i++;
        }
        return value;
    }

    private static final Map<String, Integer> M = new HashMap<>();
    static {
        M.put("I", 1);
        M.put("IV", 4);
        M.put("V", 5);
        M.put("IX", 9);
        M.put("X", 10);
        M.put("XL", 40);
        M.put("L", 50);
        M.put("XC", 90);
        M.put("C", 100);
        M.put("CD", 400);
        M.put("D", 500);
        M.put("CM", 900);
        M.put("M", 1000);
    }

    public static void main(String[] args){
        System.out.println(toInt("XCVI"));
        System.out.println(toInt("MDCCC"));
        System.out.println(toInt("CM"));
        System.out.println(toInt("DCCCXC"));
        System.out.println(toInt("DXXX"));
        System.out.println(toInt("XLIV"));
        System.out.println(toInt("XLIX"));
    }
}
