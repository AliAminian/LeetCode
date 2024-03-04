package solution.FindPeakElement;

import java.util.*;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> result = sol.combinationSum3(3, 7);
        System.out.println("hi");
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private int maxDepth;
    private int maxSum;


    public List<List<Integer>> combinationSum3(int k, int n) {
        maxDepth = k;
        maxSum = n;
        combination(new ArrayList<Integer>(), 1, maxSum);
        return ans;
    }

    private void combination(List<Integer> comb, int start, int currentSum) {
        if (comb.size() == maxDepth && maxSum == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(comb, i+1, currentSum-i);
            comb.remove(comb.size() - 1);
        }
    }
}
