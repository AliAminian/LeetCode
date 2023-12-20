package solution.DetermineifTwoStringsAreClose;

import java.util.*;

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the
 * same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.closeStrings("cabbba", "abbccc"));
    }

    public boolean closeStrings(String word1, String word2) {
        char[] ar1 = word1.toCharArray();
        char[] ar2 = word2.toCharArray();

        if (ar1.length != ar2.length) return false;

        Map<Character, Integer> w1 = new HashMap<>();
        Map<Character, Integer> w2 = new HashMap<>();

        for (char c : ar1) w1.put(c, w1.getOrDefault(c, 0) + 1);
        for (char c : ar2) w2.put(c, w2.getOrDefault(c, 0) + 1);

        if (!w1.keySet().equals(w2.keySet())) return false;

        ArrayList<Integer> s1 = new ArrayList<>(w1.values());
        ArrayList<Integer> s2 = new ArrayList<>(w2.values());
        Collections.sort(s1);
        Collections.sort(s2);

        return s1.equals(s2);
    }

}
