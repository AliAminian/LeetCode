package solution.ContainsDuplicate;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.containsDuplicate(new int[]{1, 2, 3, 1});
    }

    public boolean containsDuplicate(int[] nums) {
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            val ^= nums[i];
        }
        return false;
    }
}
