package solution.MaximumAverageSubarrayI;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxAverage(new int[]{3,3,4,3,0},3));
    }

    public double findMaxAverage(int[] nums, int k) {
        double max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
            if (i < k-1) {
                continue;
            }
            if (i == k-1) {
                max = (double)nums[i]/k;
            } else {
                double tmp = (double)(nums[i]-nums[i-k])/k;
                if (max < tmp)
                    max = tmp;
            }
        }
        return max;
    }
}
