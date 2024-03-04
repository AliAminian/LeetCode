package solution.CountingBits;

import java.util.Arrays;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countBits(5);
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " >> 1  = " + (i >> 1));
            System.out.println(i + " & 1  = " + (i & 1));
            System.out.println();

            ans[i] = ans[i >> 1] + (i & 1);
        }
        Arrays.stream(ans).forEach(System.out::println);
        return ans;
    }
}
