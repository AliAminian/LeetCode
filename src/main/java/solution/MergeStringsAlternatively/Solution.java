package solution.MergeStringsAlternatively;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting
 * with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 */

import java.lang.Math;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        StringBuilder res = new StringBuilder();
        int maxLen = Math.max(w1.length, w2.length);
        int counter = 0;
        while(counter < maxLen) {
            if (counter < w1.length) {
                res.append(w1[counter]);
            }
            if (counter < w2.length) {
                res.append(w2[counter]);
            }
            counter++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String word1 = "abcd";
        String word2 = "de";
        System.out.println(sol.mergeAlternately(word1, word2));
    }
}