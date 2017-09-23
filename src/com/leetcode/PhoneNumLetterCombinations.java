package com.leetcode;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Given a digit string, return all possible letter combinations that the number could represent.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class PhoneNumLetterCombinations {
    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        _letterCombinations(digits, 0, result, null);
        return result;
    }

    private void _letterCombinations(String d, int index, List<String> result, @Nullable StringBuilder sb){
        if(index >= d.length()){
            if(null != sb && sb.length() > 0){
                result.add(sb.toString());
            }
            return;
        }
        char[] cs = MAP[Character.digit(d.charAt(index), 10)];
        for(char c : cs){
            StringBuilder sb2 = null != sb ? new StringBuilder(sb) : new StringBuilder();
            sb2.append(c);
            _letterCombinations(d, index + 1, result, sb2);
        }
    }

    private static final char[][] MAP = new char[10][];

    static {
        MAP[0] = new char[]{' '};
        MAP[1] = new char[]{'1'};
        MAP[2] = new char[]{'a', 'b', 'c'};
        MAP[3] = new char[]{'d', 'e', 'f'};
        MAP[4] = new char[]{'g', 'h', 'i'};
        MAP[5] = new char[]{'j', 'k', 'l'};
        MAP[6] = new char[]{'m', 'n', 'o'};
        MAP[7] = new char[]{'p', 'q', 'r', 's'};
        MAP[8] = new char[]{'t', 'u', 'v'};
        MAP[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    public static void main(String[] args){
        PhoneNumLetterCombinations pnl = new PhoneNumLetterCombinations();
        test(pnl, "23");
    }

    private static void test(PhoneNumLetterCombinations pnl, String digits){
        System.out.println("INPUT: " + digits);
        for(String s : pnl.letterCombinations(digits)){
            System.out.println(s);
        }
    }
}
