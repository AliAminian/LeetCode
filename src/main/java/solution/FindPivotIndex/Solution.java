package solution.FindPivotIndex;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pivotIndex(new int[]{2,-1,1}));
    }

    public int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i-1];
        if (0 == (nums[nums.length-1]-nums[0]))
            return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == (nums[nums.length-1]-nums[i]))
                return i;
        }

        if (0 == (nums[nums.length-2]))
            return 0;

        return -1;
    }
}
