package solution.Countallpalindromicsubsequence;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countAll("aba"));
    }

    public int countAll(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++)
                if (isPalindromic(s.substring(i, j))) counter++;
        
        return counter;
    }

    public boolean isPalindromic (String sub) {
        String rev = new StringBuilder(sub).reverse().toString();
        return (rev.equals(sub));
    }

    /*
    abcdd

     */
}
