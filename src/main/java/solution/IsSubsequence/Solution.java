package solution.IsSubsequence;
/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence
 * of "abcde" while "aec" is not).
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    public boolean isSubsequence(String s, String t) {
        char[] big = s.toCharArray();
        char[] small = t.toCharArray();

        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        if (s.length() < t.length()) {
            big =  t.toCharArray();
            small = s.toCharArray();
        }
        int j = 0;
        for (char c : big) {
            if (j < small.length && small[j] == c) {
                j++;
            }
        }
        return j == small.length;
    }
}
