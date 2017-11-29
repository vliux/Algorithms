package com.leetcode;

/**
 * https://leetcode.com/problems/2-keys-keyboard/description/
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

 Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 Paste: You can paste the characters which are copied last time.
 Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

 Example 1:
 Input: 3
 Output: 3
 Explanation:
 Intitally, we have one character 'A'.
 In step 1, we use Copy All operation.
 In step 2, we use Paste operation to get 'AA'.
 In step 3, we use Paste operation to get 'AAA'.

 */
public class TwoKeysKeyboard {
    public static void main(String[] args){
        System.out.println("6 -> " + minSteps(6));
        System.out.println("9 -> " + minSteps(9));
        System.out.println("18 -> " + minSteps(18));
        System.out.println("81 -> " + minSteps(81));
    }

    public static int minSteps(int na){
        return _minSteps_(na, new Stat1(1, 0, 0));
    }

    private static int _minSteps_(int na, Stat s){
        if(s.na == na) return s.steps;
        else if(s.na > na) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(Stat ns : s.nexts()){
            int steps = _minSteps_(na, ns);
            if(steps < min) min = steps;
        }
        return min;
    }

    static abstract class Stat{
        int na;
        int steps;
        int cna;

        public Stat(int na, int steps, int cna) {
            this.na = na;
            this.steps = steps;
            this.cna = cna;
        }

        abstract Stat[] nexts();
    }

    static class Stat1 extends Stat{
        public Stat1(int na, int steps, int cna) {
            super(na, steps, cna);
        }

        @Override
        Stat[] nexts() {
            return new Stat[]{
                    new Stat2(na * 2, steps + 2, na)
            };
        }
    }

    static class Stat2 extends Stat{
        public Stat2(int na, int steps, int cna) {
            super(na, steps, cna);
        }

        @Override
        Stat[] nexts() {
            return new Stat[]{
                    new Stat1(na, steps, cna),
                    new Stat2(na + cna, steps + 1, cna)
            };
        }
    }
}
