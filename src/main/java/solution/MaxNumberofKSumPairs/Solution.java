package solution.MaxNumberofKSumPairs;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxOperations(new int[]{3,1,3,4,3}, 6));
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int count = 0;
        while(l < r){
            int vl = nums[l];
            int vr = nums[r];
            if (k == vl+vr) {
                count++;
                l++;
                r--;
            }
            if(vl+vr > k) {
                r--;
            } else if(vl+vr < k) {
                l++;
            }
        }
        return count;
    }
}
