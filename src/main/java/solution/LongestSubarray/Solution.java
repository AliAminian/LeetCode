package solution.LongestSubarray;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestSubarray(new int[]{1,1,1,0,0,0,1,1,1,1,0}));
    }

    public int longestSubarray(int[] nums) {
        int count = 0;
        int right=0;
        int left = 0;
        int ans = 0;

        while(right <  nums.length) {
            if(nums[right] == 0)
                count++;

            while(count > 1) {
                if(nums[left] == 0)
                    count--;
                left++;

            }
            ans = Math.max(ans, right-left);
            right++;
        }
        return ans;
    }
}
