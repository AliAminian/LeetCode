package solution.increasingtripletsubsequence;
/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
 * nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.increasingTriplet(new int[]{1,5,0,4,1,3});
    }

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        int i = 0;
        while(i < nums.length) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else if (min < nums[i] && mid < nums[i] && min < mid) {
                return true;
            }
            i++;
        }
        return false;
    }
}
