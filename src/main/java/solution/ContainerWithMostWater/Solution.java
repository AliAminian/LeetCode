package solution.ContainerWithMostWater;
/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container,
 * such that the container contains the most water. Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxArea(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while(l < r){
            int hl = height[l];
            int hr = height[r];
            int area = 0;
            if(hl < hr) {
                area = (r-l)*hl;
                l++;
            } else if(hl > hr) {
                area = (r-l)*hr;
                r--;
            } else {
                area = (r-l)*hr;
                l++;
                r--;
            }
            max = (max > area)? max : area;
        }
        return max;
    }
}
