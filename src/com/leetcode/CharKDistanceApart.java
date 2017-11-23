package com.leetcode;

import java.util.*;

public class CharKDistanceApart {
    public String rearrageString(String str, int d) throws Exception {
        char[] res = new char[str.length()];
        Arrays.fill(res, '\0');
        Map<Character,Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch,freq.containsKey(ch)?freq.get(ch)+1:1);
        }
        Queue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){

            @Override
            public int compare(Character a, Character b) {
                int aFreq = freq.containsKey(a)?freq.get(a):0;
                int bFreq = freq.containsKey(b)?freq.get(b):0;
                return bFreq - aFreq;
            }

        });
        pq.addAll(freq.keySet());
        int p = 0;
        while (!pq.isEmpty()) {
            Character ch = pq.poll();
            while (p < res.length && res[p]!='\0')
                p++;
            if(p == res.length)
                throw new Exception("Invalid string");
            int cnt = freq.get(ch);
            int q = p;
            while (q < res.length  && cnt > 0 ) {
                res[q] = ch;
                q+=d;
                cnt--;
            }
            if(cnt > 0)
                throw new Exception("Invalid string");
        }
        return new String(res);
    }

    public static void main(String[] args) throws Exception {
        CharKDistanceApart cda = new CharKDistanceApart();
        System.out.println(cda.rearrageString("AAABBBCC", 3));
    }
}
