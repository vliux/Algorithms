package com.leetcode;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WordBreak {
    /**
     * Exceed time limit on case 1.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Stack<Point> stack = new Stack<>();
        int start = 0; int end = 0;
        while(true){
            if(start >= s.length()) return true;
            else if(end >= s.length()){
                if(!stack.empty()){
                    Point p = stack.pop();
                    start = p.x; end = p.y;
                }else return false;
            }
            String w = s.substring(start, end + 1);
            if(wordDict.contains(w)){
                stack.push(new Point(start, end + 1));
                start = end + 1;
                end = start;
            }else end++;
        }
    }

    public boolean wordBreak2(String s, List<String> wordDict){
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args){
        WordBreak wb = new WordBreak();
        String[] dict = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        System.out.println(wb.wordBreak2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList(dict)));
        System.out.println(wb.wordBreak2("leetcode", Arrays.asList(new String[]{"lee", "leet", "co", "code"})));
    }
}
