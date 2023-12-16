package solution.ProductOfArrayExceptSelf;
/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Constraints:
 *      2 <= nums.length <= 105
 *      -30 <= nums[i] <= 30
 *      The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.productExceptSelf(new int[]{-1,1,0,-3,3});
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }

        for (int i = 0; i < nums.length-1; i++) {
            nums[i+1] *= nums[i];
        }

        for (int i = nums.length-1; i > 0; i--) {
            res[i-1] *= res[i];
        }

        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[0] = res[1];
            } else if (i == res.length-1) {
                res[res.length-1] = nums[nums.length-2];
            } else  res[i] = res[i+1]*nums[i-1];
        }
        return res;
    }
}
