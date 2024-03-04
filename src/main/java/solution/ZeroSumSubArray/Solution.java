package solution.ZeroSumSubArray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getAllZeroSumSubarrays(List.of(4, 2, -3, -1, 0, 4)));
    }

    public boolean hasZeroSumSubarray(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (set.contains(sum) || sum == 0)
                return true;
            set.add(sum);
        }

        return false;
    }

    public Set<List<Integer>> getAllZeroSumSubarrays(List<Integer> nums)
    {
        Set<List<Integer>> subarrays = new HashSet<>();

        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j+1);
                if (sum == 0) {
                    subarrays.add(nums.subList(i, j+1));
                }
            }
        }

        return subarrays;
    }

}
