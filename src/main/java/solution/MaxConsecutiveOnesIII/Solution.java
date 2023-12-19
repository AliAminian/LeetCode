package solution.MaxConsecutiveOnesIII;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestOnes(new int[]{1,1,0,0,0,0,1,1,0,0,0,0}, 2));
    }

    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        while(i < nums.length){
            if(nums[i] == 0)
                k--;
            if(k<0 && nums[j++] == 0)
                k++;
            i++;
        }
        return i-j;
    }
}
