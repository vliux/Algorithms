package com.leetcode;

/**
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class IntegerToRoman {
    public static String toRoman(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = MAP.length - 1; i >= 0 && n > 0;){
            int sub = n - MAP[i].value;
            if(sub >= 0){
                sb.append(MAP[i].name);
                n = sub;
            }else i--;
        }
        return sb.toString();
    }

    private static final Entry[] MAP = new Entry[]{
            new Entry("I", 1),
            new Entry("IV", 4),
            new Entry("V", 5),
            new Entry("IX", 9),
            new Entry("X", 10),
            new Entry("XL", 40),
            new Entry("L", 50),
            new Entry("XC", 90),
            new Entry("C", 100),
            new Entry("CD", 400),
            new Entry("D", 500),
            new Entry("CM", 900),
            new Entry("M", 1000)
    };

    private static class Entry {
        String name;
        int value;

        public Entry(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }

    public static void main(String[] args){
        System.out.println(toRoman(1800));
        System.out.println(toRoman(1500));
        System.out.println(toRoman(891));
        System.out.println(toRoman(707));
        System.out.println(toRoman(530));
        System.out.println(toRoman(550));
        System.out.println(toRoman(501));
        System.out.println(toRoman(36));
    }
}
