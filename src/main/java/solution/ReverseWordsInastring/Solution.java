package solution.ReverseWordsInastring;
/**
 * Given an input string s, reverse the order of the words. A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space. Return a string of the words in reverse order concatenated by
 * a single space. Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned
 * string should only have a single space separating the words. Do not include any extra spaces.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("  hello world  "));
    }

    public String reverseWords(String s) {
        String[] strs = s.trim().split("\s+");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i--) {
            res.append(strs[i]);
            if (i != 0)
                res.append(" ");
        }
        return res.toString();
    }

}
