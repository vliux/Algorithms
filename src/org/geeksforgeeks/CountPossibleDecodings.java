package org.geeksforgeeks;

/**
 * Count Possible Decodings of a given Digit Sequence
 * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 * Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.

 Examples:

 Input:  digits[] = "121"
 Output: 3
 // The possible decodings are "ABA", "AU", "LA"

 Input: digits[] = "1234"
 Output: 3
 // The possible decodings are "ABCD", "LCD", "AWD"
 */
public class CountPossibleDecodings {
    public static int count(char[] a, int startIndex){
        if(startIndex >= a.length) return 1;
        DecodeResult[] results = parseNext(a, startIndex);
        int count = 0;
        for(DecodeResult r : results){
            count += count(a, r.nextIndex);
        }
        return count;
    }

    private static DecodeResult[] parseNext(char[] a, int startIndex){
        char c = (char)(a[startIndex] + 17);
        DecodeResult r1 = new DecodeResult(c, startIndex + 1);
        if(startIndex >= a.length - 1){
            return new DecodeResult[]{r1};
        }else{
            int i = Integer.valueOf(new String(a, startIndex, 2));
            if(i > 26) return new DecodeResult[]{r1};
            else {
                DecodeResult r2 = new DecodeResult((char)(i + 64), startIndex + 2);
                return new DecodeResult[]{r1, r2};
            }
        }
    }

    private static class DecodeResult {
        final char c;
        final int nextIndex;

        public DecodeResult(char c, int nextIndex) {
            this.c = c;
            this.nextIndex = nextIndex;
        }
    }

    public static void main(String[] args){
        char[] input = new char[]{'1', '1', '2', '3', '1', '3', '2'};
        System.out.println(count(input, 0));
    }
}
