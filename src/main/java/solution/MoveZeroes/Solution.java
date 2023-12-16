package solution.MoveZeroes;
/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] in = new int[]{0,1,0,3,12};
        sol.moveZeroes(in);
        System.out.println(in);
    }

    public void moveZeroes(int[] nums) {
        int lastZero = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = lastZero;
            while (j <= i && nums[i] != 0) {
                if (nums[j] == 0) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                    lastZero = j;
                }
                j++;
            }
        }
    }
}
